package com.bigdata.ant.register.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.register.service.RegisterMonitorServiceImpl;

@Controller
public class RegisterMonitorController {
	@Resource
	private RegisterMonitorServiceImpl registerMonitorServiceImpl;
	
	@RequestMapping("/checkMonitorEmail")
	public void checkMonitorEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mon_email = request.getParameter("mon_email");
		Boolean bool = registerMonitorServiceImpl.findMonitorByEmail(mon_email);
		if (bool == true) {// 数据库中已存在该班委
			System.out.println("已存在班委");
			response.getWriter().print("no");
		} else {// 该班委可以注册
			System.out.println("可以注册");
			response.getWriter().print("ok");
		}
	}

	@RequestMapping("/monitorRegister")
	public String monitorRegister(HttpServletRequest request,HttpServletResponse response,Monitor monitor) throws ServletException, IOException {
		String againpsd = request.getParameter("againpsd");
		String college=request.getParameter("college");
		String profession=request.getParameter("profession");
		String grade=request.getParameter("grade");
		String classes=request.getParameter("classes");

		String admitMonitorRegister = registerMonitorServiceImpl.admitMonitorRegister(monitor, college,profession,grade,classes,againpsd);// 获得信息（是否允许注册）

		if (admitMonitorRegister.equals("0")) {// 该用户注册成功，待激活
			registerMonitorServiceImpl.processMonitorRegister(monitor,college,profession,grade,classes);
			request.setAttribute("msg", "注册成功，去邮箱激活吧");
			return "register_msg";
		} else {
			System.out.println("admit");
			request.setAttribute("admitMonitorRegister", admitMonitorRegister);
			request.setAttribute("collegeSelected", college);
			request.setAttribute("professionSelected", profession);
			request.setAttribute("gradeSelected", grade);
			request.setAttribute("classesSelected", classes);
			request.setAttribute("monitor", monitor);
			request.setAttribute("againpsd", againpsd);
			System.out.println(college);
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
	@RequestMapping("/activeMonitor")
	public String activeMonitor(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String validateCode = request.getParameter("validateCode");
		String msg = registerMonitorServiceImpl.VolidateMonitorRegister(email, validateCode);
		request.setAttribute("msg", msg);
		return "register_msg";
	}
}
