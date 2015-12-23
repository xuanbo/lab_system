package com.whut.lab.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tools.EncodingTool;

import com.whut.lab.web.service.TeachProgramService;
import com.whut.lab.web.service.TeachResourceService;

@Controller
public class TeachResourceController {

	@Autowired
	@Qualifier("teachProgramService")
	private TeachProgramService teachProgramService;
	
	@Autowired
	@Qualifier("teachResourceService")
	private TeachResourceService teachResourceService;
	
	
	/**
	 * 教师,学生查看教学资源
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/teacher/teacherProgram/{id}/teachResource/list","/student/teacherProgram/{id}/teachResource/list"}, method = RequestMethod.GET)
	public String list(@PathVariable int id, ModelMap modelMap){
		modelMap.addAttribute("teachResources", teachProgramService.get(id).getTeachResource());
		return "teachResource/list";
	}
	
	@RequestMapping(value = "/teacherProgram/teachResource/download")  
    public ModelAndView download(HttpServletRequest request,  
            HttpServletResponse response, @RequestParam String fileName) throws Exception {   
		
		//解决链接上中文参数乱码问题
		String storeName = EncodingTool.encodeStr(fileName);
        String contentType = "application/octet-stream";  
        TeachResourceController.download(request, response, storeName, contentType);  
        return null;  
    }  
	
	/**
	 * 文件下载 主要方法
	 * @param request
	 * @param response
	 * @param storeName
	 * @param contentType
	 * @throws Exception
	 */
    public static void download(HttpServletRequest request,  
            HttpServletResponse response, String storeName, String contentType
           ) throws Exception {  
    	
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  
        //获取项目根目录
        String ctxPath = request.getSession().getServletContext()  
                .getRealPath("");  
        
        //获取下载文件的路径
        String downLoadPath = ctxPath+"/download/teachResource/"+ storeName;  
        
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
