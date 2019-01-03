/**
 * @Title:SaveSInformation.java
 * @Package:com.bigdata.ant.personalinformation.controller
 * @Description:点击提交后，更新个人信息
 * @Author:吕凝慧
 * @Date:2018年12月17日
 */
package com.bigdata.ant.personalinformation.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata.ant.entity.ClassInfo;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.personalinformation.service.SaveSInformationServiceImpl;

/**
 * @ClassName:SaveSInformation
 * @Description:更新个人信息
 * @Author 吕凝慧
 * @Date:2018年12月17日
 *
 */
@Controller
public class SaveSInformationController {
	@Resource
	private SaveSInformationServiceImpl savesinformationserviceimpl;

	@RequestMapping(value = "/saveSinformation", method = RequestMethod.POST)
//	public String findStu(Student stu) {
//		System.out.println("save");
////		Student student=this.savesinformationserviceimpl.findStu(id);
////		savesinformationserviceimpl.updateSInf(stu);
//		System.out.println(stu.getName());
//		return "student_PersonalInformation";
//	}
	public String saveSinf(HttpServletRequest request,HttpSession session) {
		System.out.println("save");
		//得到当前用户
		Student s = (Student) session.getAttribute("s");
		//name修改
		String sname=request.getParameter("sname");
		s.setName(sname);
		//邮件修改
		String semail=request.getParameter("semail");
		s.setEmail(semail);
		//classId的修改
		String sclass=request.getParameter("sclass");
		String sprofession=request.getParameter("sprofession");
		String sgrade=request.getParameter("sgrade");	
		//根据sclass,sprofession.sgrade得到唯一class_id
		ClassInfo classinfo=this.savesinformationserviceimpl.saveClassId(sclass,sprofession,sgrade);
		s.setClassInfo(classinfo);
		
		//把属性更新至数据库
		this.savesinformationserviceimpl.updateSInf(s);
		session.setAttribute("s", s);
		
		return ("student_personalInformation");
	}

}
