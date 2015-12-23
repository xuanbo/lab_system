package com.whut.lab.web.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.entity.Score;
import com.whut.lab.web.entity.TeachProgram;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.LabActivityService;
import com.whut.lab.web.service.ScoreService;
import com.whut.lab.web.service.StudentService;
import com.whut.lab.web.service.TeachProgramService;

@Controller
public class StudentController {
	
	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;
	
	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	@Autowired
	@Qualifier("teachProgramService")
    private TeachProgramService teachProgramService;
	
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	
	/**
	 * 学生登入
	 * @return
	 */
	@RequestMapping(value="/student/{id}/index", method = RequestMethod.GET)
	public String index(@PathVariable int id,ModelMap modelMap, HttpServletRequest request){	
		modelMap.addAttribute("student", studentService.get(id));
		return "student/index";
	}
	
	
	/**
	 * 学生查看教师的预约成功记录
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/student/{id}/labActivity/list", method = RequestMethod.GET)
	public String labActivityList(@PathVariable int id, ModelMap modelMap){
		String labActivityState = "预约成功";
		int majorClassId = studentService.get(id).getMajorClass().getId();
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setSize(10);
		pages.setTotalCount(labActivityService.getByMajorClassIdAndLabActivityStateCount(majorClassId, labActivityState));
		pages.setList(labActivityService.getByMajorClassIdAndLabActivityState(majorClassId, labActivityState, 1, 10));
		
		modelMap.addAttribute("pages", pages);
		return "student/labActivityList";
	}	
	/**
	 * 分页
	 * 局部刷新div，而不是整个body
	 */
	@RequestMapping(value="/student/{id}/labActivity/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView labActivityListByPage(@PathVariable int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		String labActivityState = "预约成功";
		int majorClassId = studentService.get(id).getMajorClass().getId();
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(labActivityService.getByMajorClassIdAndLabActivityStateCount(majorClassId, labActivityState));
		pages.setList(labActivityService.getByMajorClassIdAndLabActivityState(majorClassId, labActivityState, current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("student/labActivityListDate");
		return modelAndView;
	}
	
	
	/**
	 * 学生查看教学计划信息
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/student/{id}/teachProgram/list", method = RequestMethod.GET)
	public String teachProgramList(@PathVariable int id, ModelMap modelMap){
		int majorClassId = studentService.get(id).getMajorClass().getId();
		Page<TeachProgram> pages = new Page<TeachProgram>();
		pages.setCurrent(1);
		pages.setSize(10);
		pages.setTotalCount(teachProgramService.getByMajorClassIdCount(majorClassId));
		pages.setList(teachProgramService.getByMajorClassId(majorClassId, 1, 10));
		
		modelMap.addAttribute("pages", pages);
		return "student/teachProgramList";
	}
	@RequestMapping(value="/student/{id}/teachProgram/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView teachProgramListByPage(@PathVariable int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		int majorClassId = studentService.get(id).getMajorClass().getId();
		Page<TeachProgram> pages = new Page<TeachProgram>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(teachProgramService.getByMajorClassIdCount(majorClassId));
		pages.setList(teachProgramService.getByMajorClassId(majorClassId, current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("student/teachProgramListDate");
		return modelAndView;
	}
	
	
	/**
	 * 学生查看实验成绩
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/student/{id}/score/list", method = RequestMethod.GET)
	public String scoreList(@PathVariable int id, ModelMap modelMap){
		Page<Score> pages = new Page<Score>();
		pages.setCurrent(1);
		pages.setSize(1);
		pages.setTotalCount(scoreService.getCountByStudentId(id));
		pages.setList(scoreService.getByStudentId(id, 1, 1));
		
		modelMap.addAttribute("pages", pages);
		return "student/scoreList";
	}
	@RequestMapping(value="/student/{id}/score/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView scoreListByPage(@PathVariable int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		Page<Score> pages = new Page<Score>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(scoreService.getCountByStudentId(id));
		pages.setList(scoreService.getByStudentId(id, current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("student/scoreListDate");
		return modelAndView;
	}
}
