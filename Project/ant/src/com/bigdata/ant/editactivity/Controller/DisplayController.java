/**
 * @Title:displayController.java
 * @Package:com.bigdata.ant.editactivity.Controller
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月24日
 */
package com.bigdata.ant.editactivity.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.editactivity.Service.DisplayServiceImpl;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.register.service.RegisterStudentServiceImpl;

import oracle.jrockit.jfr.ActiveSettingEvent;


/**
 * @ClassName:displayController
 * @Description:编辑组织发布的信息页面
 * @Author 吕凝慧
 * @Date:2018年12月24日
 *
 */
@Controller
public class DisplayController {
	@Resource
	private DisplayServiceImpl displayserviceimpl;
	@Resource
	private RegisterStudentServiceImpl registerStudentServiceImpl;
	@RequestMapping(value="/display")
	public String display(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name=request.getParameter("act");
		System.out.println(name);
		Activity activity=this.displayserviceimpl.findActivtyByname(name);
		request.setAttribute("activity", activity);
		//格式化日期类
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("ApplyBegin", sdf.format(activity.getApplyBegin()));
		request.setAttribute("ApplyEnd", sdf.format(activity.getApplyEnd()));
		request.setAttribute("HoldBegin", sdf.format(activity.getHoldBegin()));
		request.setAttribute("HoldEnd", sdf.format(activity.getHoldEnd()));
		request.setAttribute("college", registerStudentServiceImpl.findCollege());// 把学院信息查出来
		//判断活动阶段
		Set<ActivityStage> activityStage= activity.getActivityStages();
		if(activityStage.size()==1) {
			System.out.println("size1");
			request.setAttribute("Stage", activityStage.iterator().next().getStage());
			//获得活动加分
			request.setAttribute("score", activityStage.iterator().next().getScore());
		}else if(activityStage.size()==2) {
			System.out.println("size2");
			for (ActivityStage activityStage2 : activityStage) {
				if(activityStage2.getStage().equals("决赛")) {
					System.out.println("决赛");
					request.setAttribute("Stage", "决赛");
					//获得活动加分
					request.setAttribute("score", activityStage2.getScore());
				}else if(activityStage2.getStage().equals("复赛")) {
					request.setAttribute("Stage", "复赛");
					System.out.println("复赛");
					//获得活动加分
					request.setAttribute("score", activityStage2.getScore());
				}
			}
		}else if(activityStage.size()==3) {
			System.out.println("size3");
			for (ActivityStage activityStage3 : activityStage) {
				if(activityStage3.getStage().equals("决赛")) {
					System.out.println("决赛");
					request.setAttribute("Stage", "决赛");
					//获得活动加分
					request.setAttribute("score", activityStage3.getScore());
				}
			}
		}
		session.setAttribute("activity", activity);
		
		//完成跳转
		return "organization_editactivity";
	}	
}
