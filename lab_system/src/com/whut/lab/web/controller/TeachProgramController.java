package com.whut.lab.web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tools.RandomString;

import com.whut.lab.web.entity.MajorClass;
import com.whut.lab.web.entity.TeachProgram;
import com.whut.lab.web.entity.TeachResource;
import com.whut.lab.web.entity.Teacher;
import com.whut.lab.web.entity.User;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.TeachProgramService;
import com.whut.lab.web.service.TeachResourceService;
import com.whut.lab.web.service.TeacherService;
import com.whut.lab.web.service.UserService;

/**
 * 教学计划Controller
 * @author xuan
 *
 */
@Controller
public class TeachProgramController {

	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	
	@Autowired
	@Qualifier("teachProgramService")
	private TeachProgramService teachProgramService;
	
	@Autowired
	@Qualifier("teachResourceService")
	private TeachResourceService teachResourceService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	/**
	 * 教师查看教学计划
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/{id}/teachProgram/list", method = RequestMethod.GET)
	public String list(@PathVariable int id, ModelMap modelMap){
		//modelMap.addAttribute("teachPrograms", teacherService.get(id).getTeachPrograms());
		Page<TeachProgram> pages = new Page<TeachProgram>();
		pages.setCurrent(1);
		//pages.setTotalCount((int) teacherService.get(id).getTeachPrograms().size());
		String hql = "select tp "
				+ "from Teacher t join t.teachPrograms tp "
				+ "where t.id=" + id;
		String counthql = "select count(*) "
				+ "from Teacher t join t.teachPrograms tp "
				+ "where t.id=" + id;
		pages.setTotalCount(teachProgramService.getTotalCount(counthql));
		pages.setSize(10);
		pages.setList(teachProgramService.getByPage(hql, 1, 10));
		modelMap.addAttribute("pages", pages);
		modelMap.addAttribute("teacherid", id);
		return "teachProgram/list";
	}
	/**
	 * 分页查看
	 * @param modelMap
	 * @return 
	 * @return
	 */
	@RequestMapping(value="/teacher/{id}/teachProgram/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView listByPage(@PathVariable int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		
		Page<TeachProgram> pages = new Page<TeachProgram>();
		pages.setCurrent(current);
		String hql = "select tp "
				+ "from Teacher t join t.teachPrograms tp "
				+ "where t.id=" + id;
		String counthql = "select count(*) "
				+ "from Teacher t join t.teachPrograms tp "
				+ "where t.id=" + id;
		pages.setTotalCount(teachProgramService.getTotalCount(counthql));
		pages.setSize(size);
		pages.setList(teachProgramService.getByPage(hql, current, size));
		
		modelAndView.setViewName("teachProgram/list");
		modelAndView.addObject("teacherid", id);
		modelAndView.addObject("pages", pages);
		return modelAndView;
	}
	
	/**
	 * 教师上传教学资源
	 * @param file
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/teacher/teachResource/add",method=RequestMethod.POST)
	public @ResponseBody JSONObject handleFileUpload(@RequestParam("file") MultipartFile file, 
			HttpServletRequest request, @RequestParam("teachProgramId") int id){
		JSONObject jsonObject = new JSONObject();
		if (!file.isEmpty()) {
			 try {
				 //获取文件的原始名字
				 String fileName = file.getOriginalFilename();
				 // 获取图片的扩展名
			     String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
			     // 新的图片文件名 = 获取时间戳+随机生成字符串+"."+图片扩展名
				 RandomString randomString = new RandomString();
				 @SuppressWarnings("static-access")
				 String randomName = randomString.getRandomString(10);
			     //更改文件名
				 Date now = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	             String newName = dateFormat.format(now) + randomName + "." + extensionName;
	             
	             //String path = "/download/teachResource/"+newName;
	             //String realpath = request.getSession().getServletContext().getRealPath(path);	             
	             //System.out.println(realpath);
	             String path = "G:/database_shiyan/lab_system/WebContent/download/teachResource/"+newName;	             
	             
	             File localFile = new File(path);
	             //将文件写到本地
	             file.transferTo(localFile);
	             
	             
	             //图片上传是否成功的标志
	             jsonObject.put("flag", "success");
	             //上传图片的地址
	             jsonObject.put("url", newName);
	             
	             
	             /**
	              * 将教师上传的资源保存到数据库
	              */
	             TeachProgram teachProgram = teachProgramService.get(id);
	             TeachResource teachResource = new TeachResource();
	             teachResource.setName(fileName);
	             teachResource.setUrl(newName);
	             teachResource.setTeachProgram(teachProgram);
	             teachResourceService.save(teachResource);
	             
	             
	             return jsonObject;
	             } catch (Exception e) {
	            	 jsonObject.put("flag", e.getMessage());
	            	 jsonObject.put("url", "null");
	            	 return jsonObject;
	            }
	        } else {
	        	jsonObject.put("flag", "You failed to upload,because the file was empty.");
	        	jsonObject.put("url", "null");
	            return jsonObject;
	        }
	}
	
	
	/**
	 * 教师新增教学计划页面
	 * @param modelMap
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/teacher/teachProgram/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request){
		/**
		 * 获取session中的用户名
		 * 通过用户名获取到user对象
		 */
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContextImpl.getAuthentication().getName();
		User user = userService.getByName(username).get(0);
		
		Teacher teacher = user.getTeacher();
		
		modelMap.addAttribute("majorClasses", teacher.getMajorClasses());
		modelMap.addAttribute("teacherId", teacher.getId());
		return "teachProgram/add";
	}
	
	/**
	 * 教师新增教学计划
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value="/teacher/teachProgram/add",method=RequestMethod.POST)
	public @ResponseBody JSONObject add(@RequestBody JSONObject jsonObject){
		
		TeachProgram teachProgram = new TeachProgram();
		teachProgram.setName(jsonObject.getString("name"));
		teachProgram.setTime(new Date());
		
		Teacher teacher = teacherService.get(jsonObject.getInt("tId"));
		teachProgram.setTeacher(teacher);
		
		Set<MajorClass> majorClasses = teacher.getMajorClasses();
		for(MajorClass majorClass :  majorClasses){
			MajorClass mc = majorClass;
			if(mc.getName().equals(jsonObject.get("majorClass"))){
				teachProgram.setMajorClass(mc);
			}
		}
		
		teachProgramService.save(teachProgram);
		
		/*
		 * 此时teachProgram已成为持久态
		 */
		//System.out.println(teachProgram.getId());
		
		JSONObject result = new JSONObject();
		result.put("flag", true);
		result.put("teachProgramId", teachProgram.getId());
	    return result;
	}
}
