package com.bigdata.ant.applied.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata.ant.applied.service.ShowAppliedActivityServiceImpl;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.Student;
@Controller
public class ShowAppliedActivityController {
	@Resource
	private ShowAppliedActivityServiceImpl showAppliedActivityServiceImpl;
	@RequestMapping(value="appliedacts",method=RequestMethod.GET)
	public String listAppliedActivity(HttpServletRequest request,HttpSession session) {
		Student student = (Student) session.getAttribute("s");
		String stuId = student.getId();
		List<Activity> appliedActsWithNotBegin = this.showAppliedActivityServiceImpl.listAppliedActsWithNotBegin(stuId);
		if(appliedActsWithNotBegin.equals(null)==false) {
			request.setAttribute("appliedActsWithNotBegin",appliedActsWithNotBegin);
		}else {
			request.setAttribute("appliedActsWithNotBegin",null);
		}
		List<Activity> appliedActsOnHolding = this.showAppliedActivityServiceImpl.listAppliedActsOnHolding(stuId);
		if(appliedActsOnHolding.equals(null)==false) {
			request.setAttribute("appliedActsOnHolding",appliedActsOnHolding);
		}else {
			request.setAttribute("appliedActsOnHolding",null);
		}
		List<Activity> appliedActsWithAlreadyEnd = this.showAppliedActivityServiceImpl.listAppliedActsWithAlreadyEnd(stuId);
		if(appliedActsWithAlreadyEnd.equals(null)==false) {
			request.setAttribute("appliedActsWithAlreadyEnd",appliedActsWithAlreadyEnd);
		}else {
			request.setAttribute("appliedActsWithAlreadyEnd",null);
		}
		
		return "student_personalcenter";
	}
}
