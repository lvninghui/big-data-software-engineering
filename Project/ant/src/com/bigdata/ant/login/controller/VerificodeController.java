package com.bigdata.ant.login.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.login.util.VerifiCode;

/**
 * 
 * @ClassName:VerificodeController
 * @Description:判断验证码是否正确
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Controller
public class VerificodeController {
	/**
	 * 
	 * @Title: doGet
	 * @Description:验证码验证
	 * @param:@param request
	 * @param:@param response
	 * @param:@throws ServletException
	 * @param:@throws IOException (参数)
	 * @return:void(返回类型)
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/vert")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * 1.生成验证码 2.把验证码上的文本存在session中 3.把验证码图片发送给客户端
		 */
		VerifiCode v = new VerifiCode(); // 用我们的验证码类，生成验证码类对象
		BufferedImage image = v.getImage(); // 获取验证码
		request.getSession().setAttribute("text", v.getText()); // 将验证码的文本存在session中
		v.output(image, response.getOutputStream());// 将验证码图片响应给客户端
	}
}
