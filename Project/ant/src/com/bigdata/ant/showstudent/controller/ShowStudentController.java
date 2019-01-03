package com.bigdata.ant.showstudent.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.applied.service.ShowAppliedActivityServiceImpl;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.Comprehensive;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.scan.service.ScannedActivityServiceImpl;
import com.bigdata.ant.showstudent.service.ShowStudentServiceImpl;

@Controller
public class ShowStudentController {
	@Resource
	private ShowStudentServiceImpl showStudentServiceImpl;
	@Resource
	private ScannedActivityServiceImpl scannedActivityServiceImpl;
	@Resource
	private ShowAppliedActivityServiceImpl showAppliedActivityServiceImpl;

	@RequestMapping("/personalcenter")
	public String showStudent(HttpServletRequest request, Model model, HttpSession session) {
		Long activitynum = this.showStudentServiceImpl.countActivity();
		model.addAttribute("activityNum", activitynum);
		Student student = (Student) session.getAttribute("s");
		String stuId = student.getId();
		if (stuId != null) {
			float nowScore = this.showStudentServiceImpl.FindScore(stuId);
			Long studentActivityNum = this.showStudentServiceImpl.CountStudentactivity(stuId);
			model.addAttribute("nowScore", nowScore);
			model.addAttribute("studentActivityNum", studentActivityNum);
		}
		List<Activity> actList = this.scannedActivityServiceImpl.findScannedActivityList(stuId);
		if (actList.equals(null) == false) {
			request.setAttribute("scannedActList", actList);
		} else {
			request.setAttribute("scannedActList", null);
		}
		List<Activity> appliedActsWithNotBegin = this.showAppliedActivityServiceImpl.listAppliedActsWithNotBegin(stuId);
		if (appliedActsWithNotBegin.equals(null) == false) {
			request.setAttribute("appliedActsWithNotBegin", appliedActsWithNotBegin);
		} else {
			request.setAttribute("appliedActsWithNotBegin", null);
		}
		List<Activity> appliedActsOnHolding = this.showAppliedActivityServiceImpl.listAppliedActsOnHolding(stuId);
		if (appliedActsOnHolding.equals(null) == false) {
			request.setAttribute("appliedActsOnHolding", appliedActsOnHolding);
		} else {
			request.setAttribute("appliedActsOnHolding", null);
		}
		List<Activity> appliedActsWithAlreadyEnd = this.showAppliedActivityServiceImpl
				.listAppliedActsWithAlreadyEnd(stuId);
		if (appliedActsWithAlreadyEnd.equals(null) == false) {
			request.setAttribute("appliedActsWithAlreadyEnd", appliedActsWithAlreadyEnd);
		} else {
			request.setAttribute("appliedActsWithAlreadyEnd", null);
		}
		return "student_personalcenter";

	}

}
