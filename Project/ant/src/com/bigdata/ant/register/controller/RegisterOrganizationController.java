package com.bigdata.ant.register.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.register.service.RegisterOrganizationServiceImpl;


@Controller
public class RegisterOrganizationController {
	@Resource
	private RegisterOrganizationServiceImpl registerOrganizationServiceImpl;
	
	@RequestMapping("/checkOrganizationEmail")
	public void checkOrganizationEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String org_email = request.getParameter("org_email");
		Boolean bool = registerOrganizationServiceImpl.findOrganizationByEmail(org_email);
		if (bool == true) {// 数据库中已存在该班委
			System.out.println("已存在班委");
			response.getWriter().print("no");
		} else {// 该班委可以注册
			System.out.println("可以注册");
			response.getWriter().print("ok");
		}
	}
	
	
	@RequestMapping("/organizationRegister")
	public String organizationRegister(HttpServletRequest request, HttpServletResponse response,Organization organization) throws ServletException, IOException {
		String againpsd = request.getParameter("againpsd");
		String belong = request.getParameter("belong");
		String orgName=request.getParameter("org_name");

		String admitOrganizationRegister = registerOrganizationServiceImpl.admitOrganizationRegister(organization, belong,orgName,againpsd);// 获得信息（是否允许注册）
		if (admitOrganizationRegister.equals("0")) {// 该用户注册成功，待激活
			registerOrganizationServiceImpl.processOrganizationRegister(organization, belong,orgName,againpsd);
			request.setAttribute("msg", "注册成功，去邮箱激活吧");
			return "register_msg";
		} else {
			System.out.println("admit");
			request.setAttribute("admitOrganizationRegister", admitOrganizationRegister);
			request.setAttribute("belongSelected", belong);
			request.setAttribute("orgNameSelected", orgName);
			request.setAttribute("organization", organization);
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
	@RequestMapping("/activeOrganization")
	public String activeMonitor(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String validateCode = request.getParameter("validateCode");
		String msg = registerOrganizationServiceImpl.VolidateOrganizationRegister(email, validateCode);
		request.setAttribute("msg", msg);
		return "register_msg";
	}
}
