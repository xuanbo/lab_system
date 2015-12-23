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

import com.whut.lab.web.entity.Equipment;
import com.whut.lab.web.entity.LossEquipment;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.EquipmentService;
import com.whut.lab.web.service.LossEquipmentService;

@Controller
public class EquipmentController {

	@Autowired
	@Qualifier("equipmentService")
	private EquipmentService equipmentService;
	
	@Autowired
	@Qualifier("lossEquipmentService")
	private LossEquipmentService lossEquipmentService;
	
	
	/**
	 * 管理员查看所有的实验器材
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/labAdmin/equipment/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap){
		Page<Equipment> pages = new Page<Equipment>();
		pages.setCurrent(1);
		pages.setSize(8);
		pages.setTotalCount(equipmentService.getTotalCount());
		pages.setList(equipmentService.getByPage(1, 8));
		
		modelMap.addAttribute("pages", pages);
		return "equipment/list";
	}
	@RequestMapping(value="/labAdmin/equipment/listByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView listByPage(@RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		Page<Equipment> pages = new Page<Equipment>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(equipmentService.getTotalCount());
		pages.setList(equipmentService.getByPage(current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("equipment/list");
		return modelAndView;
	}
	
	/**
	 * 管理员查询某个实验器材的使用详情
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/labAdmin/equipment", method = RequestMethod.GET)
	public String detail(@RequestParam int id, ModelMap modelMap){
		Page<LossEquipment> pages = new Page<LossEquipment>();
		pages.setCurrent(1);
		pages.setSize(8);
		pages.setTotalCount(lossEquipmentService.getCountByEquipmentId(id));
		pages.setList(lossEquipmentService.getByEquipmentId(id, 1, 8));
		
		modelMap.addAttribute("pages", pages);
		modelMap.addAttribute("equipmentId", id);
		return "equipment/details";
	}
	@RequestMapping(value="/labAdmin/equipmentByPage", method = RequestMethod.POST)
	public @ResponseBody ModelAndView detailByPage(@RequestParam int id, @RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");
		Page<LossEquipment> pages = new Page<LossEquipment>();
		pages.setCurrent(current);
		pages.setSize(size);
		pages.setTotalCount(lossEquipmentService.getCountByEquipmentId(id));
		pages.setList(lossEquipmentService.getByEquipmentId(id, current, size));
		
		modelAndView.addObject("pages", pages);
		modelAndView.addObject("equipmentId", id);
		modelAndView.setViewName("equipment/details");
		return modelAndView;
	}
	
	/**
	 * 管理员新增实验器材
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value="/labAdmin/equipment/add", method = RequestMethod.POST)
	public @ResponseBody boolean addEquipment(@RequestBody JSONObject jsonObject){
		/**
		 * 如果该实验器材没有添加过，则新增
		 */
		if(equipmentService.getByName(jsonObject.getString("name")).isEmpty()){
			
			Equipment equipment = new Equipment();
			equipment.setName(jsonObject.getString("name"));
			equipment.setLossNumber(0);
			equipment.setStyle(jsonObject.getString("style"));
			equipment.setTotalNumber(jsonObject.getInt("totalNumber"));
			
			equipmentService.save(equipment);
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 增加实验器材
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value="/labAdmin/equipment/puls", method = RequestMethod.POST)
	public @ResponseBody boolean plusEquipment(@RequestBody JSONObject jsonObject){
		Equipment equipment = equipmentService.get(jsonObject.getInt("id"));
		equipment.setTotalNumber(equipment.getTotalNumber() + jsonObject.getInt("number"));
		equipmentService.update(equipment);
		return true;
	}
}
