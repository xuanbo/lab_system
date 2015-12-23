package com.whut.lab.web.controller;

import net.sf.json.JSONArray;
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
import com.whut.lab.web.entity.MajorClass;
import com.whut.lab.web.entity.Score;
import com.whut.lab.web.entity.Student;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.LabActivityService;
import com.whut.lab.web.service.ScoreService;
import com.whut.lab.web.service.StudentService;

@Controller
public class ScoreController {

	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;
	
	
	/**
	 * 给某次实验的学生评分
	 * @param id 某次预约实验id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/{id}/giveScore", method = RequestMethod.GET)
	public String giveScore(@PathVariable int id, ModelMap modelMap){
		MajorClass majorClass = labActivityService.get(id).getMajorClass();
		modelMap.addAttribute("labActivityId", id);
		modelMap.addAttribute("students", majorClass.getStudents());
		
		/**
		 * 如果本次实验还没有评价分数，那么让其评分
		 */
		if(labActivityService.get(id).getScores().isEmpty()){
		    modelMap.addAttribute("flag", "可以评分");
		}else{
			modelMap.addAttribute("flag", null);
		}
		
		return "score/giveScore";
	}
	
	/**
	 * 实验结束后老师给学生评分post提交处理
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/giveScore", method = RequestMethod.POST)
	public @ResponseBody boolean giveScorePost(@RequestBody JSONObject jsonObject){
		
		LabActivity labActivity = labActivityService.get(jsonObject.getInt("labActivityId"));
		
		/**
		 * 获取保存分数和学生id的分数数组
		 */
		JSONArray scores = jsonObject.getJSONArray("scoreArray");
		
		for(int i = 0; i < scores.size(); i ++){
			/**
			 * 获取每一个对象
			 */
			JSONObject score = scores.getJSONObject(i);			
			
			Student student = studentService.get(score.getInt("id"));
			
			Score s = new Score();		
			s.setGrade(score.getInt("score"));
			s.setMark(score.getString("mark"));		
			s.setStudent(student);
			s.setLabActivity(labActivity);
			
			scoreService.save(s);
			
		}
		return true;
	}
	
	
	/**
	 * 老师查看实验已结束的预约记录
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/{id}/labActivity/score", method = RequestMethod.GET)
	public String list(@PathVariable int id, ModelMap modelMap){
		String labActivityState = "实验已结束";
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setTotalCount(labActivityService.getCount(id, labActivityState));
		pages.setSize(10);
		pages.setList(labActivityService.get(id, labActivityState, 1, 10));
		
		modelMap.addAttribute("pages", pages);		
		return "score/list";
	}
	
	@RequestMapping(value="/teacher/{id}/labActivity/scoreByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView listByPage(@PathVariable int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		String labActivityState = "实验已结束";
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");	
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setTotalCount(labActivityService.getCount(id, labActivityState));
		pages.setSize(size);
		pages.setList(labActivityService.get(id, labActivityState, current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("score/list");
		return modelAndView;
	}

	/**
	 * 教师查看某次实验的成绩
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="teacher/labActivity/{id}/score", method = RequestMethod.GET)
	public String labActivityScore(@PathVariable int id, ModelMap modelMap){
		modelMap.addAttribute("scores", labActivityService.get(id).getScores());
		return "score/labActivityScore";
	}
}
