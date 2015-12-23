package com.whut.lab.web.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.whut.lab.web.model.Page;
import com.whut.lab.web.model.TeacherInfo;
import com.whut.lab.web.service.CourseService;
import com.whut.lab.web.service.TeacherService;

@Controller
public class majorClassCourseController {

	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	/**
	 * 教师查看自己的授课信息页面
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/{id}/majorClassCourse/list", method = RequestMethod.GET)
	public String list(@PathVariable int id, ModelMap modelMap){
		Page<TeacherInfo> pages = new Page<TeacherInfo>();
		pages.setCurrent(1);
		pages.setTotalCount(teacherService.getTeacherInfo(id).size());
		pages.setSize(2);
		pages.setList(teacherService.getByPage(id, 1, 2));
		
		modelMap.addAttribute("pages", pages);		
		//modelMap.addAttribute("teacherInfos", teacherService.getTeacherInfo(id));
		return "majorClassCourse/list";
	}
	
	@RequestMapping(value="/teacher/{id}/majorClassCourse/listByPage", method = RequestMethod.POST)
	public ModelAndView listByPage(@PathVariable int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");	
		Page<TeacherInfo> pages = new Page<TeacherInfo>();
		pages.setCurrent(current);
		pages.setTotalCount(teacherService.getTeacherInfo(id).size());
		pages.setSize(size);
		pages.setList(teacherService.getByPage(id, current, size));
		
		modelAndView.addObject("pages", pages);		
		modelAndView.setViewName("majorClassCourse/list");
		return modelAndView;
	}
}
