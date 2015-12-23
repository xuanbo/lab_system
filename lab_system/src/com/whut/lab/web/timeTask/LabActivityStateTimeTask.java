package com.whut.lab.web.timeTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.service.LabActivityService;

/**
 * 定时器用来自动将到期的实验 预约成功状态 变更为 实验已结束
 * @author xuan
 *
 */
@Component
public class LabActivityStateTimeTask{
    /**
     * CRON表达式 含义 
     * "0 0 12 * * ?"    每天中午十二点触发 
     * "0 15 10 ? * *"    每天早上10：15触发 
     * "0 15 10 * * ?"    每天早上10：15触发 
     * "0 15 10 * * ? *"    每天早上10：15触发 
     * "0 15 10 * * ? 2005"    2005年的每天早上10：15触发 
     * "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发 
     * "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发 
     * "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
     * "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发 
     * "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发 
     * "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发 
     */
	
	@Autowired
	@Qualifier("labActivityService")
	private LabActivityService labActivityService;
	
	
	/**
	 * 每天定时执行，将过期的实验预约成功状态更改为实验已结束
	 */
	@Scheduled(cron = "0 58 23 ? * *")
	public void labActivityEnd(){
		System.out.println("定时器启动");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		/**
		 * 获取预约成功的记录
		 */		
		Iterator<LabActivity> iterator = labActivityService.get("预约成功").iterator();
		while(iterator.hasNext()){
		    LabActivity labActivity = iterator.next();
			try {
				Date end = dateFormat.parse(labActivity.getEnd());
				Date date = new Date();
			    if(end.getTime() <= date.getTime()){
			    	labActivity.setState("实验已结束");
				    labActivityService.update(labActivity);
			    }
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    		    
		}
		
		System.out.println("定时器结束");
	}
}
