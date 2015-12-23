package com.whut.lab.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whut.lab.web.service.LabActivityService;
import com.whut.lab.web.service.LabAdminService;

@Controller
public class LabAdminController {

	@Autowired
	@Qualifier("labAdminService")
	private LabAdminService labAdminService;
	
	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	/**
	 * 实验室管理员登入
	 * @return
	 */
	@RequestMapping(value="labAdmin/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		modelMap.addAttribute("msg", "请选择您要进行的任务");
		//预约待处理的条数
		modelMap.addAttribute("count", labActivityService.getCount("预约待处理"));
		return "labAdmin/index";
	}
}
