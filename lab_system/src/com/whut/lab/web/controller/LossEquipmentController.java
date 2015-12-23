package com.whut.lab.web.controller;

import java.util.HashSet;
import java.util.Set;

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

import com.whut.lab.web.entity.Equipment;
import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.entity.LossEquipment;
import com.whut.lab.web.service.EquipmentService;
import com.whut.lab.web.service.LabActivityService;
import com.whut.lab.web.service.LossEquipmentService;

@Controller
public class LossEquipmentController {

	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	@Autowired
	@Qualifier("equipmentService")
	private EquipmentService equipmentService;
	
	@Autowired
	@Qualifier("lossEquipmentService")
	private LossEquipmentService lossEquipmentService;
	
	
	/**
	 * 实验耗材填写页面
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/{id}/lossEquipment", method = RequestMethod.GET)
	public String lossEquipmentAdd(@PathVariable int id, ModelMap modelMap){
		modelMap.addAttribute("labActivityId", id);
		modelMap.addAttribute("equipments", labActivityService.get(id).getEquipments());
		
		/**
		 * 如果本次实验还没有填写实验器材损耗，那么让其填写
		 */
		if(labActivityService.get(id).getLossEquipments().isEmpty()){
		    modelMap.addAttribute("flag", "可以填写");
		}else{
			modelMap.addAttribute("flag", null);
		}
		
		return "lossEquipment/add";
	}
	
	/**
	 * 实验器材耗材情况提交
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/lossEquipment", method = RequestMethod.POST)
	public @ResponseBody boolean lossEquipmentAddPost(@RequestBody JSONObject jsonObject){
        LabActivity labActivity = labActivityService.get(jsonObject.getInt("labActivityId"));

		/**
		 * 获取保存耗损器材信息数组
		 */
		JSONArray lossEquipments = jsonObject.getJSONArray("lossEquipmentArray");
		
		for(int i = 0; i < lossEquipments.size(); i ++){
			
			/**
			 * 获取每一个对象
			 */
			JSONObject lossEquipment = lossEquipments.getJSONObject(i);	
			
			Set<Equipment> equipments = new HashSet<Equipment>();
			Equipment equipment = equipmentService.get(lossEquipment.getInt("id"));
			/**
			 * 原来的损耗加上现在的损耗
			 */
			equipment.setLossNumber(equipment.getLossNumber()+lossEquipment.getInt("lossNumber"));
			equipments.add(equipment);
			
			LossEquipment lossEquip = new LossEquipment();			
			lossEquip.setLabActivity(labActivity);
			lossEquip.setLossNumber(lossEquipment.getInt("lossNumber"));
			lossEquip.setEquipments(equipments);
			
			
			lossEquipmentService.save(lossEquip);
		}
		return true;
	}
}
