/**
 * @Title:PersonalInformationController.java
 * @Package:com.bigdata.ant.personalinformation.controller
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月14日
 */
package com.bigdata.ant.personalinformation.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.College;
import com.bigdata.ant.entity.Profession;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.personalinformation.service.PersonalInformationServiceImpl;

/**
 * @ClassName:PersonalInformationController
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2018年12月14日
 *
 */
@Controller
public class PersonalInformationController {
	@Resource
	private PersonalInformationServiceImpl personalinformationserviceimpl;

	@RequestMapping(value = "/personalinformation")
	public String queryPersonalInformation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("s");
		// 查询所有的学院信息
		List<College> collegeinformation = this.personalinformationserviceimpl.collegeInformation();
		request.setAttribute("college", collegeinformation);
		//查询所有的专业信息
		List<Profession> professioninformationall=this.personalinformationserviceimpl.professionInformationall();
		request.setAttribute("profession", professioninformationall);
		// 查询所在学院的专业信息
		// int collegeid=student.getClassInfo().getProfession().getCollege().getId();
		// List<Profession>
		// profession=this.personalinformationserviceimpl.professionInformation(collegeid);

		return "student_personalInformation";
	}

}
