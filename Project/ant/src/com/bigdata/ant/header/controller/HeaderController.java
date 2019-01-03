/**
 * @Title:HeaderController.java
 * @Package:com.bigdata.ant.header.controller
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月5日
 */
package com.bigdata.ant.header.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigdata.ant.header.service.HeaderServiceImpl;
import com.google.gson.Gson;

/**
 * @ClassName:HeaderController
 * @Description:TODO（搜素框自动补全功能）
 * @Author 成琼
 * @Date:2018年12月5日
 *
 */
@Controller
@RequestMapping("/header")
public class HeaderController {
	@Resource
	private HeaderServiceImpl headerServiceImpl;

	/**
	 * 
	 * @Title: findActivitiesNames
	 * @Description: TODO(根据关键字查找包含此关键字的活动名称)
	 * @param:@param keyword
	 * @param:@param response (关键字)
	 * @return:void(返回类型)
	 */
	@RequestMapping("/search")
	public void findActivitiesNames(@RequestParam("text") String keyword, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		try {
			list = headerServiceImpl.findActivitiesNames(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String re = gson.toJson(list);
		System.out.println(re + "json");
		try {
			response.getWriter().print(re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong");
			e.printStackTrace();
		}

	}

}
