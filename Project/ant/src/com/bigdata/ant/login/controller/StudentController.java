package com.bigdata.ant.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.login.service.StudentServiceImpl;

/**
 * 
 * @ClassName:StudentController
 * @Description:学生登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Controller
public class StudentController {

	@Resource
	private StudentServiceImpl studentServiceImpl;

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
	@RequestMapping("/stu_login")
	public String Login(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String session_vcode = (String) session.getAttribute("text"); // 从session中获取真正的验证码
		String form_vcode = request.getParameter("vcode"); // 获取用户输入的验证码
		boolean a = this.studentServiceImpl.getById(id);
		boolean b = this.studentServiceImpl.getStuByIdAndPwd(id, pwd);
		if (a == false) {
			request.setAttribute("message1", "请输入正确的用户名！");
			return "three_login";
		} else if (b == false) {
			request.setAttribute("message2", "请输入正确的密码");
			return "three_login";
		} else if (!(session_vcode.equalsIgnoreCase(form_vcode))) // 进行判断
		{
			request.setAttribute("msg", "验证码错误"); // 如果错误就将错误信息发送给客户端
			return "three_login";
		} else {
			Student s = this.studentServiceImpl.getStuById(id);
			if (s.getStatus() == 0) {
				request.setAttribute("message1", "该用户未被激活！");
				return "three_login";
			} else {
				s.setPhoto("images/photo.jpg");
				session.setAttribute("s", s);
				return "student_index";
			}
		}
	}
}
