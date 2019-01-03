package com.bigdata.ant.register.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.register.service.RegisterStudentServiceImpl;
import com.bigdata.ant.utils.IncreaseTimeUtil;

@Controller
public class RegisterStudentController {

	@Resource
	private RegisterStudentServiceImpl registerStudentServiceImpl;

	/**
	 * 
	 * @Title: toRegister
	 * @Description: TODO(这里用一句话描述这个方法的作用) 注册前获得数据（学院等信息）
	 * @param: (参数)
	 * @return:void(返回类型)
	 *
	 */
	@RequestMapping("/toRegister")
	public String toRegister(HttpServletRequest request) {
		request.setAttribute("college", registerStudentServiceImpl.findCollege());// 把学院信息查出来
		request.setAttribute("grade", IncreaseTimeUtil.addDateYear(4));// 把年级信息查出来
		request.setAttribute("classes", registerStudentServiceImpl.findClasses());// 把班级信息列出来
		return "three_register";

	}

	/**
	 * 
	 * @Title: checkStudentId
	 * @Description: TODO(这里用一句话描述这个方法的作用)通过学生id查找是否存在该学生
	 * @param:@param request
	 * @param:@param response
	 * @param:@throws IOException (参数)
	 * @return:void(返回类型)
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkStudentId")
	public void checkStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String student_id = request.getParameter("student_id");
		Boolean bool = registerStudentServiceImpl.findStudentById(student_id);
		if (bool == true) {// 数据库中已存在该学生
			System.out.println("已存在学生");
			response.getWriter().print("no");
		} else {// 该学生可以注册
			System.out.println("可以注册");
			response.getWriter().print("ok");
		}
	}

	/**
	 * 
	 * @Title: studentRegister
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param request
	 * @param:@param response
	 * @param:@param student
	 * @param:@throws IOException (参数)
	 * @return:void(返回类型)
	 *
	 * @param request
	 * @param response
	 * @param student
	 * @throws IOException
	 * @throws ServletException 
	 */
	@RequestMapping("/studentRegister")
	public String studentRegister(HttpServletRequest request,HttpServletResponse response, Student student) throws IOException, ServletException {
		String againpsd = request.getParameter("againpwd");
		String admitStudentRegister = registerStudentServiceImpl.admitStudentRegister(student, againpsd);// 获得信息（是否允许注册）
		if (admitStudentRegister.equals("0")) {// 该用户注册成功，待激活
			registerStudentServiceImpl.processRegister(student);
			request.setAttribute("msg", "注册成功，去邮箱激活吧");
			return "register_msg";
		} else {
			request.setAttribute("admitStudentRegister", admitStudentRegister);
			request.setAttribute("student", student);
			request.setAttribute("againpsd", againpsd);
			request.getRequestDispatcher("toRegister").forward(request, response);
			return null;
		}
	}

	/**
	 * 
	 * @Title: activeStudent
	 * @Description: TODO(这里用一句话描述这个方法的作用) 激活该用户
	 * @param: (参数)
	 * @return:void(返回类型)
	 * @throws IOException
	 * @throws ServletException
	 *
	 */
	@RequestMapping("/activeStudent")
	public String activeStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String validateCode = request.getParameter("validateCode");
		String msg = registerStudentServiceImpl.VolidateRegister(email, validateCode);
		request.setAttribute("msg", msg);
		request.setAttribute("email", email);
		request.getRequestDispatcher("toPerfectInformation").forward(request, response);
		return null;
	}
	
	@RequestMapping("/toPerfectInformation")
	public String toPerfectInformation(HttpServletRequest request) {
		String email=request.getParameter("email");
		System.out.println("email"+email);
		request.setAttribute("college", registerStudentServiceImpl.findCollege());// 把学院信息查出来
		request.setAttribute("grade", IncreaseTimeUtil.addDateYear(4));// 把年级信息查出来
		request.setAttribute("classes", registerStudentServiceImpl.findClasses());// 把班级信息列出来
		request.setAttribute("email", email);
		return "student_perfectinformation";

	}
	@RequestMapping("/afterPerfectInformation")
	public String afterPerfectInformation(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		System.out.println(email);
		String college=request.getParameter("college");
		String profession=request.getParameter("profession");
		String grade=request.getParameter("grade");
		String classes=request.getParameter("classes");
		String admitStudentPerfect = registerStudentServiceImpl.admitStudentPerfect(college, profession, grade, classes);// 获得信息（是否允许注册）
		if (admitStudentPerfect.equals("0")) {
			registerStudentServiceImpl.perfectStudentInformation(email, college, profession, grade, classes);
			request.setAttribute("msg", "信息完善成功");
			return "register_msg";
		} else {
			request.setAttribute("admitStudentPerfect", admitStudentPerfect);
			request.setAttribute("collegeSelected", college);
			request.setAttribute("professionSelected", profession);
			request.setAttribute("gradeSelected", grade);
			request.setAttribute("classesSelected", classes);
			request.getRequestDispatcher("toPerfectInformation").forward(request, response);
			return null;
		}

	}

}
