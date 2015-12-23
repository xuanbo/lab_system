package com.whut.lab.web.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.lab.web.entity.Role;
import com.whut.lab.web.entity.User;
import com.whut.lab.web.security.CustomUserDetailsService;
import com.whut.lab.web.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("userService")
	private UserService uesrService;
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private CustomUserDetailsService customUserDetailsService;
	
	
	/**
	 * 登录界面
	 */
	@RequestMapping(value = "/login**", method = RequestMethod.GET)
	public ModelAndView loginPage(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login"); 
		return model; 
	}
	
	/**
	 * 登录验证
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/validate", method = RequestMethod.POST)
	public @ResponseBody boolean loginValidate(@RequestBody JSONObject json, HttpSession session){
		
		if(uesrService.isFindPasswordByName(json.getString("name"), json.getString("password"))){
			
			/**
			 * spring security 将权限及用户信息存入securityContext  
			 */
		    UserDetails userDetails = customUserDetailsService.loadUserByUsername(json.getString("name"));  
		    Authentication authentication = new UsernamePasswordAuthenticationToken(    
		            userDetails, userDetails.getPassword(), userDetails.getAuthorities());  
		    SecurityContext securityContext = SecurityContextHolder.getContext();  
		    securityContext.setAuthentication(authentication);    
		    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		    
		    /**
		     * 把用户角色存储到session
		     */
		    User user = uesrService.getByName(json.getString("name")).get(0);
		    Set<Role> roles = user.getRoles();
		    for(Role role : roles){
		    	if(role.getName().equals("labAdmin")){
		    		session.setAttribute("Role", "实验室管理员");
		    	}else if(role.getName().equals("teacher")){
		    		session.setAttribute("Role", "教师");
		    		System.out.println(user.getTeacher().getId());
		    		session.setAttribute("TEACHERID", user.getTeacher().getId());
		    	}else{
		    		session.setAttribute("Role", "学生");
		    		session.setAttribute("STUDENTID", user.getStudent().getId());
		    	}
		    	
		    }	    		    
			return true;
		}else{
			return false;
		}
		
	}
	
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	
	/** 
     * 指定无访问额权限页面 
     *  
     * @return 
     */  
    @RequestMapping(value = "/denied**", method = RequestMethod.GET)  
    public String deniedPage() {   
        return "denied";  
    }
    
}
