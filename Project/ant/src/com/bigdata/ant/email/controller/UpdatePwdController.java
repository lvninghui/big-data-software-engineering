package com.bigdata.ant.email.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.email.service.UpdatePwdServiceImpl;

/**
 * 
 * @ClassName:UpdatePwdController
 * @Description:更改密码
 * @Author xujunmei
 * @Date:2018年12月10日
 *
 */
@Controller
public class UpdatePwdController {

	@Resource
	private UpdatePwdServiceImpl updatePwdServiceImpl;

	/**
	 * 
	 * @Title: UpdatePwd
	 * @Description: 重置密码
	 * @param:@param request
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatepwd")
	public String UpdatePwd(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		this.updatePwdServiceImpl.ChangePwd(email, pwd);
		return "updatepwd_success";
	}

}
