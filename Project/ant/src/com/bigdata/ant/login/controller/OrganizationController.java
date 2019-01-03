package com.bigdata.ant.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.login.service.OrganizationServiceImpl;

/**
 * 
 * @ClassName:OrganizationController
 * @Description:组织者登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Controller
public class OrganizationController {

	@Resource
	private OrganizationServiceImpl organizationServiceImpl;

	/**
	 * 
	 * @Title: Login
	 * @Description: 账号密码验证
	 * @param:@param request
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/org_login")
	public String Login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String session_vcode = (String) session.getAttribute("text"); // 从session中获取真正的验证码
		String form_vcode = request.getParameter("vcode"); // 获取用户输入的验证码
		boolean a = this.organizationServiceImpl.getOrgByEmail(email);
		boolean b = this.organizationServiceImpl.getOrgByEmailAndPwd(email, pwd);
		if (a == false) {
			request.setAttribute("message5", "请输入正确的邮箱！");
			return "three_login";
		} else if (b == false) {
			request.setAttribute("message6", "请输入正确的密码！");
			return "three_login";
		} else if (!(session_vcode.equalsIgnoreCase(form_vcode))) // 进行判断
		{
			request.setAttribute("message", "验证码错误"); // 如果错误就将错误信息发送给客户端
			return "three_login";
		} else {
			Organization o = this.organizationServiceImpl.FindName(email);
			if (o.getStatus() == 0) {
				request.setAttribute("message5", "该用户未被激活！");
				return "three_login";
			} else {
				session.setAttribute("o", o);
				return "organization_index";
			}
		}
	}

}
