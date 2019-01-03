package com.bigdata.ant.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.login.service.MonitorServiceImpl;

/**
 * 
 * @ClassName:MonitorController
 * @Description:班委登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Controller
public class MonitorController {

	@Resource
	private MonitorServiceImpl monitorServiceImpl;

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
	@RequestMapping("/mon_login")
	public String Login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String session_vcode = (String) session.getAttribute("text"); // 从session中获取真正的验证码
		String form_vcode = request.getParameter("vcode"); // 获取用户输入的验证码
		boolean a = this.monitorServiceImpl.getMonByEmail(email);
		boolean b = this.monitorServiceImpl.getMonByEmailAndPwd(email, pwd);
		if (a == false) {
			request.setAttribute("message3", "请输入正确的邮箱！");
			return "three_login";
		} else if (b == false) {
			request.setAttribute("message4", "请输入正确的密码！");
			return "three_login";
		} else if (!(session_vcode.equalsIgnoreCase(form_vcode))) // 进行判断
		{
			request.setAttribute("message", "验证码错误"); // 如果错误就将错误信息发送给客户端
			return "three_login";
		} else {
			Monitor m = this.monitorServiceImpl.getMonitor(email);
			if (m.getStatus() == 0) {
				request.setAttribute("message3", "该用户未被激活！");
				return "three_login";
			} else {
				session.setAttribute("m", m);
				return "monitor_index";
			}
		}
	}
}
