package com.whut.lab.web.controller; 

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tools.EncodingTool;

import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.entity.LabClass;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.LabActivityService;
import com.whut.lab.web.service.LabClassService;
import com.whut.lab.web.service.UserService;

@Controller
public class LabClassController {

	@Autowired
	@Qualifier("labClassService")
	private LabClassService labClassService;
	
	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	/**
	 * 管理员查看所有实验室
	 * @return
	 */
	@RequestMapping(value="/labAdmin/labClass/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap){
		Page<LabClass> pages = new Page<LabClass>();
		pages.setCurrent(1);
		pages.setSize(10);
		pages.setTotalCount(labClassService.getTotalCount());
		pages.setList(labClassService.getByPage(1, 10));
		
		modelMap.addAttribute("pages", pages);
		return "labClass/list";
	}
	@RequestMapping(value="/labAdmin/labClass/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView listByPage(@RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		Page<LabClass> pages = new Page<LabClass>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(labClassService.getTotalCount());
		pages.setList(labClassService.getByPage(current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("labClass/list");
		return modelAndView;
	}
	
	
	/**
	 * 管理员或老师查询某个实验室的详情
	 * @param id   实验室id
	 * @return
	 */
	@RequestMapping(value="/labClass", method = RequestMethod.GET)
	public String labClassDetail(@RequestParam int id, ModelMap modelMap){
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setSize(8);
		pages.setTotalCount(labActivityService.getByLabClassIdCount(id));
		pages.setList(labActivityService.getByLabClassId(id, 1, 8));
		
		modelMap.addAttribute("labClass", labClassService.get(id));
		modelMap.addAttribute("labActivityState", "all");
		modelMap.addAttribute("pages", pages);
		return "labClass/detail";
	}
	@RequestMapping(value="/labClassByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView labClassDetailByPage(@RequestParam int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(labActivityService.getByLabClassIdCount(id));
		pages.setList(labActivityService.getByLabClassId(id, current, size));
		
		modelAndView.addObject("labClass", labClassService.get(id));		
		modelAndView.addObject("pages", pages);
		modelAndView.addObject("labActivityState", "all");
		modelAndView.setViewName("labClass/detail");
		return modelAndView;
	}
	
	
	/**
	 * 管理员根据实验室id和实验室预约状态查询
	 * @param json
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/labClass/search", method = RequestMethod.GET)
	public  String labClassBylabActivityState(@RequestParam String id, 
			@RequestParam String state, ModelMap modelMap){

		int labClassId = Integer.parseInt(id);
		String labActivityState = EncodingTool.encodeStr(state);
		
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setSize(8);
		pages.setTotalCount(labActivityService.getByLabClassAndLabActivityStateCount(labClassId, labActivityState));
		pages.setList(labActivityService.getByLabClassAndLabActivityState(labClassId, labActivityState, 1, 8));
		
		modelMap.addAttribute("labClass", labClassService.get(labClassId));
		modelMap.addAttribute("labActivityState", labActivityState);
	    modelMap.addAttribute("pages", pages);	
		return "labClass/detail";		
	}
	@RequestMapping(value="/labClass/searchByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView labClassBylabActivityStateByPage(@RequestParam String id, 
			@RequestParam String state, @RequestBody JSONObject jsonObject){
        ModelAndView modelAndView = new ModelAndView();
        int size = jsonObject.getInt("size");
        int current = jsonObject.getInt("current");
		int labClassId = Integer.parseInt(id);
		String labActivityState = EncodingTool.encodeStr(state);
		
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(labActivityService.getByLabClassAndLabActivityStateCount(labClassId, labActivityState));
		pages.setList(labActivityService.getByLabClassAndLabActivityState(labClassId, labActivityState, current, size));
		
		modelAndView.addObject("labClass", labClassService.get(labClassId));
		modelAndView.addObject("labActivityState", labActivityState);
		modelAndView.addObject("pages", pages);	
		modelAndView.setViewName("labClass/detail");
		return modelAndView;		
	}
	
	
	/**
	 * 管理员新增实验室
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/labClass/add", method = RequestMethod.POST)
	public @ResponseBody boolean addLabClass(@RequestParam String name){
	    String labClassName = EncodingTool.encodeStr(name);
	    /**
	     * 如果实验室不存在，就添加
	     */
	    if(labClassService.getByName(labClassName).isEmpty()){
	    	LabClass labClass = new LabClass();
	    	labClass.setName(labClassName);
	    	labClassService.save(labClass);
	    	return true;
	    }else{
	    	return false;
	    }
	}
	
	
	
	/**
	 * 教师查看实验室
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/labClass/list", method = RequestMethod.GET)
	public String labClassList(ModelMap modelMap){
		Page<LabClass> pages = new Page<LabClass>();
		pages.setCurrent(1);
		pages.setTotalCount(labClassService.getTotalCount());
		pages.setSize(10);
		pages.setList(labClassService.getByPage(1, 10));
		
		modelMap.addAttribute("pages", pages);	
		return "teacher/labClassList";
	}
	@RequestMapping(value="/teacher/labClass/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView labClassListByPage(@RequestBody JSONObject jsonObject){
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		ModelAndView modelAndView = new ModelAndView();
		Page<LabClass> pages = new Page<LabClass>();
		pages.setCurrent(current);
		pages.setTotalCount(labClassService.getTotalCount());
		pages.setSize(size);
		pages.setList(labClassService.getByPage(current, size));
		
		modelAndView.addObject("pages", pages);	
		modelAndView.setViewName("teacher/labClassList");
		return modelAndView;
	}
	
	/**
	 * 教师查看实验是详情
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/labClass", method = RequestMethod.GET)
	public String labClassDetailByTeacher(@RequestParam int id, ModelMap modelMap){
		String labActivityState = "预约成功";
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setTotalCount(labActivityService.getByLabClassAndLabActivityStateCount(id, labActivityState));
		pages.setSize(10);
		pages.setList(labActivityService.getByLabClassAndLabActivityState(id, labActivityState, 1, 10));
		
		modelMap.addAttribute("pages", pages);	
		
		modelMap.addAttribute("labClass", labClassService.get(id));		
		return "teacher/labClassDetail";	
	}
	@RequestMapping(value="/teacher/labClassByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView labClassDetailByTeacherByPage(@RequestParam int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		String labActivityState = "预约成功";
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setTotalCount(labActivityService.getByLabClassAndLabActivityStateCount(id, labActivityState));
		pages.setSize(size);
		pages.setList(labActivityService.getByLabClassAndLabActivityState(id, labActivityState, current, size));
		
		modelAndView.addObject("pages", pages);	
		
		modelAndView.addObject("labClass", labClassService.get(id));
		modelAndView.setViewName("teacher/labClassDetail");
		return modelAndView;	
	}
}
