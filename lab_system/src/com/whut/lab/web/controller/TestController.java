package com.whut.lab.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tools.EncodingTool;

import com.whut.lab.web.entity.User;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.UserService;

/**
 * 测试controller
 * @author xuan
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	/**
	 * 测试显示数据库user表的用户
	 * @return
	 */
	@RequestMapping(value="/user/list", method = RequestMethod.GET)
	public ModelAndView Test(){
		ModelAndView model = new ModelAndView();
		model.setViewName("test/test");
		model.addObject("title", "基于baseServiceImpl的测试，测试有多少个用户");
		Page<User> pages = new Page<User>();
		pages.setCurrent(1);
		pages.setTotalCount((int) userService.getTotalCount());
		pages.setSize(3);
		pages.setList(userService.getByPage(1, 3));
		model.addObject("pages", pages);
		return model;
	}
	
	@RequestMapping(value="/user/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView users(@RequestBody JSONObject jsonObject){
		ModelAndView model = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		model.setViewName("test/test");
		model.addObject("title", "基于baseServiceImpl的测试，测试有多少个用户");
		
		Page<User> pages = new Page<User>();
		pages.setCurrent(current);
		pages.setSize(size);
		int totalCount = (int) userService.getTotalCount();
		pages.setTotalCount(totalCount);
		pages.setList(userService.getByPage(current, size));
		
		model.addObject("pages", pages);
		return model;
	}
	
	
	/**
	 * 测试用户名和密码是否匹配
	 */
	@RequestMapping(value="/isMatch", method = RequestMethod.GET)
	public @ResponseBody boolean TestIsFindPasswordByName(@RequestParam String name, 
		@RequestParam String password){
		if(userService.isFindPasswordByName(name, password)){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 测试文件下载
	 * @return
	 */
	@RequestMapping(value="/fileDownload", method = RequestMethod.GET)
	public String TestFileDownload(){
		return "test/fileDownload";
	}
	@RequestMapping(value = "/fileDownload/download")  
    public ModelAndView download(HttpServletRequest request,  
            HttpServletResponse response, @RequestParam String fileName) throws Exception {   
		
		//解决链接上中文参数乱码问题
		String storeName = EncodingTool.encodeStr(fileName);
        String contentType = "application/octet-stream";  
        TestController.download(request, response, storeName, contentType);  
        return null;  
    }  
	
	//文件下载 主要方法
    public static void download(HttpServletRequest request,  
            HttpServletResponse response, String storeName, String contentType
           ) throws Exception {  
    	
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  
        //获取项目根目录
        String ctxPath = request.getSession().getServletContext()  
                .getRealPath("");  
        
        //获取下载文件
        String downLoadPath = ctxPath+"/download/test/"+ storeName;  
        
        //获取文件的长度
        long fileLength = new File(downLoadPath).length();  

        //设置文件输出类型
        response.setContentType("application/octet-stream");  
        response.setHeader("Content-disposition", "attachment; filename="  
                + new String(storeName.getBytes("utf-8"), "ISO8859-1")); 
        //设置输出长度
        response.setHeader("Content-Length", String.valueOf(fileLength));  
        //获取输入流
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
        //输出流
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        //关闭流
        bis.close();  
        bos.close();  
    }  
}
