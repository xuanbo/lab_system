package com.whut.lab.web.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.lab.web.entity.Course;
import com.whut.lab.web.entity.Equipment;
import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.entity.LabClass;
import com.whut.lab.web.entity.MajorClass;
import com.whut.lab.web.entity.Teacher;
import com.whut.lab.web.entity.User;
import com.whut.lab.web.model.Page;
import com.whut.lab.web.service.CourseService;
import com.whut.lab.web.service.EquipmentService;
import com.whut.lab.web.service.LabActivityService;
import com.whut.lab.web.service.LabClassService;
import com.whut.lab.web.service.MajorClassService;
import com.whut.lab.web.service.TeacherService;
import com.whut.lab.web.service.UserService;

@Controller
public class TeacherController {

	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	
	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("equipmentService")
	private EquipmentService equipmentService;
	
	@Autowired
	@Qualifier("labClassService")
	private LabClassService labClassService;
	
	@Autowired
	@Qualifier("majorClassService")
	private MajorClassService majorClassService;
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	
	/**
	 * 教师登入
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/teacher/index", method = RequestMethod.GET)
	public String index(){
		return "teacher/index";
	}
	
	/**
	 * 根据预约实验室状态查询labActivity记录
	 * @param state
	 * @param modelMap
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/teacher/{id}/labActivity/state/{state}", method = RequestMethod.GET)
	public String labActivityState(@PathVariable int id, @PathVariable String state, ModelMap modelMap){
		/**
		 * 判断要查询的state
		 */
		String labActivityState = null;
		if(state.equals("process")){
			labActivityState = "预约待处理";
		}else if(state.equals("fail")){
			labActivityState = "预约失败";
		}else if(state.equals("success")){
			labActivityState = "预约成功";
		}else{
			labActivityState = "实验已结束";
		}
		
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(1);
		pages.setTotalCount(labActivityService.getCount(id, labActivityState));
		pages.setSize(10);
		pages.setList(labActivityService.get(id, labActivityState, 1, 10));
		
		modelMap.addAttribute("pages", pages);		
		modelMap.addAttribute("title", labActivityState);
		modelMap.addAttribute("teacherid", id);
		
		if(labActivityState.equals("实验已结束")){
			return "teacher/labActivityEndHandle";
		}else{
			return "teacher/labActivityList";
		}		
	}
	
	/**
	 * 教师分页查看预约信息
	 * @param id
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value= "/teacher/{id}/labActivity/state/{state}", method = RequestMethod.POST)
	public @ResponseBody ModelAndView labActivityListByPage(@PathVariable int id, @PathVariable String state,
			@RequestBody JSONObject jsonObject){
		ModelAndView modelAndView = new ModelAndView();
		/**
		 * 判断要查询的state
		 */
		String labActivityState = null;
		if(state.equals("process")){
			labActivityState = "预约待处理";
		}else if(state.equals("fail")){
			labActivityState = "预约失败";
		}else if(state.equals("success")){
			labActivityState = "预约成功";
		}else{
			labActivityState = "实验已结束";
		}
		
		int current = jsonObject.getInt("current");
		int size = jsonObject.getInt("size");	
		Page<LabActivity> pages = new Page<LabActivity>();
		pages.setCurrent(current);
		pages.setTotalCount(labActivityService.getCount(id, labActivityState));
		pages.setSize(size);
		pages.setList(labActivityService.get(id, labActivityState, current, size));		
		
		modelAndView.addObject("pages", pages);
		modelAndView.addObject("title", labActivityState);
		
		if(labActivityState.equals("实验已结束")){
			System.out.println("实验已结束");
			modelAndView.setViewName("teacher/labActivityEndHandle");
		}else{
			modelAndView.setViewName("teacher/labActivityList");
		}
		return modelAndView;
	}
	
	/**
	 * 教师查看某次预约实验所需的实验器材
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/{id}/equipments", method = RequestMethod.GET)
	public String labActivityEquipment(@PathVariable int id, ModelMap modelMap){
		modelMap.addAttribute("equipments", labActivityService.get(id).getEquipments());		
		return "teacher/equipmentDetails";
	}
	
	/**
	 * 新增预约页面
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/add", method = RequestMethod.GET)
	public String addLabActivity(ModelMap modelMap, HttpServletRequest request){
		/**
		 * 获取session中的用户名
		 * 通过用户名获取到user对象
		 */
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContextImpl.getAuthentication().getName();
		User user = userService.getByName(username).get(0);
		
		Teacher teacher = user.getTeacher();
		
		modelMap.addAttribute("equipments", equipmentService.getAll());
		modelMap.addAttribute("labClasses", labClassService.getAll());
		modelMap.addAttribute("majorClasses", teacherService.get(teacher.getId()).getMajorClasses());
		modelMap.addAttribute("courses", teacherService.get(teacher.getId()).getCourses());

		return "teacher/addLabActivity";
	}
	
	/**
	 * 新增实验预约post处理
	 * @param jsonObject
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/teacher/labActivity/add", method = RequestMethod.POST)
	public @ResponseBody boolean addLabActivityPost(@RequestBody JSONObject jsonObject,
			HttpServletRequest request){		
		try {
			/**
			 * 获取session中的用户名
			 * 通过用户名获取到user对象
			 */
			SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			String username = securityContextImpl.getAuthentication().getName();
			User user = userService.getByName(username).get(0);
			
			Teacher teacher = user.getTeacher();
			MajorClass majorClass = majorClassService.getByName(jsonObject.getString("majorClass")).get(0);
			Course course = courseService.getByName(jsonObject.getString("course")).get(0);
			LabClass labClass = labClassService.getByName(jsonObject.getString("labClass")).get(0);
			Set<Equipment> equipments = new HashSet<>();
			
			LabActivity labActivity = new LabActivity();
			/**
			 * 设置开始和结束时间以及预约状态
			 */
			labActivity.setBegin(jsonObject.getString("begin"));
			labActivity.setEnd(jsonObject.getString("end"));
			labActivity.setState("预约待处理");
			/**
			 * 将各种关联对象保存到labActivity
			 */
			labActivity.setTeacher(teacher);
			labActivity.setMajorClass(majorClass);
			labActivity.setCourse(course);
			labActivity.setLabClass(labClass);
			
			/**
			 * 遍历获取equipment，然后依次保存到set<Equipment>，最终保存到labActivity
			 */
			JSONArray equipmentsArray = jsonObject.getJSONArray("equipments");
			for(int i = 0; i < equipmentsArray.size(); i++){
				String equipmentName = equipmentsArray.get(i).toString();
				Equipment equipment = equipmentService.getByName(equipmentName).get(0);
				equipments.add(equipment);
			}
			labActivity.setEquipments(equipments);
			
			labActivityService.save(labActivity);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return true;
	}
	
}
