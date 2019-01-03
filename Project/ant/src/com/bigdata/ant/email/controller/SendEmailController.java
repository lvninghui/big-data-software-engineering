package com.bigdata.ant.email.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.email.service.SendEmailServiceImpl;

/**
 * 
 * @ClassName:SendEmailController
 * @Description: 忘记密码，邮箱验证
 * @Author xujunmei
 * @Date:2018年12月10日
 *
 */
@Controller
public class SendEmailController {
	@Resource
	private SendEmailServiceImpl sendEmailServiceImpl;

	/**
	 * 
	 * @Title: SendEmail
	 * @Description: 验证邮箱
	 * @param:@param request
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/send")
	public String SendEmail(HttpServletRequest request) {
		String email = request.getParameter("email");
		boolean b = this.sendEmailServiceImpl.FindEmail(email);// 判断数据库中是否有此email
		request.setAttribute("email", email);
		if (b == true) {
			this.sendEmailServiceImpl.SendEmail(email);
			return "three_login";
		} else {
			request.setAttribute("message", "请输入注册时使用的邮箱！");
			return "three_sendemail";
		}
	}

}
