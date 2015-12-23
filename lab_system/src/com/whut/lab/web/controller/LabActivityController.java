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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.LabActivityService;

@Controller
public class LabActivityController {

	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	
	/**
	 * 管理员查看实验室预约待处理页面,或者查看预约成功、失败、实验已结束
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/labAdmin/labActivity/{state}", method = RequestMethod.GET)
	public String list(@PathVariable String state, ModelMap modelMap){
		String labActivityState;
		if(state.equals("list")){
			labActivityState = "预约待处理";
		}else if(state.equals("stateOk")){
			labActivityState = "预约成功";
		}else if(state.equals("stateFail")){
			labActivityState = "预约失败";
		}else{
			labActivityState = "实验已结束";
		}
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setSize(10);
		pages.setTotalCount(labActivityService.getCount(labActivityState));
		pages.setList(labActivityService.get(labActivityState, 1, 10));
		
		modelMap.addAttribute("pages", pages);
		modelMap.addAttribute("title", labActivityState);
		
		if(state.equals("list")){
			return "labActivity/list";
		}else{
			return "labActivity/labActivityState";
		}
	}
	@RequestMapping(value="/labAdmin/labActivity/{state}/byPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView listByPage(@PathVariable String state, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		String labActivityState;
		if(state.equals("list")){
			labActivityState = "预约待处理";
		}else if(state.equals("stateOk")){
			labActivityState = "预约成功";
		}else if(state.equals("stateFail")){
			labActivityState = "预约失败";
		}else{
			labActivityState = "实验已结束";
		}
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(labActivityService.getCount(labActivityState));
		pages.setList(labActivityService.get(labActivityState, current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.addObject("title", labActivityState);
		
		if(state.equals("list")){
			modelAndView.setViewName("labActivity/list");
			return modelAndView;
		}else{
			modelAndView.setViewName("labActivity/labActivityState");
			return modelAndView;
		}
	}
	
	
	/**
	 * 管理员查看预约实验室所需要的实验器材
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/labAdmin/labActivity/{id}/equipments", method = RequestMethod.GET)
	public String equipmentDetails(@PathVariable int id, ModelMap modelMap){
		modelMap.addAttribute("equipments", labActivityService.get(id).getEquipments());
		return "labActivity/equipmentDetails";
	}
	
	
	/**
	 * g管理员对实验室预约情况进行审核处理
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value="/labAdmin/labActivity/valid", method = RequestMethod.POST)
	public @ResponseBody boolean valid(@RequestBody JSONObject jsonObject){
	    LabActivity labActivity = labActivityService.get(jsonObject.getInt("id"));
	    labActivity.setState(jsonObject.getString("state"));
	    labActivityService.update(labActivity);
		return true;
	}
}
