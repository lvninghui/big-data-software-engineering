package com.bigdata.ant.comprehensive.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.comprehensive.service.ComprehensiveServiceImpl;
import com.bigdata.ant.entity.Monitor;

/**
 * 
 * @ClassName:ComprehensiveController算综测，下载综测表
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月26日
 *
 */
@Controller
public class ComprehensiveController {
	@Resource
	private ComprehensiveServiceImpl comprehensiveServiceImpl;

	/**
	 * 
	 * @Title: addressComprehensive
	 * @Description: TODO(这里用一句话描述这个方法的作用) 将综测分数插入到数据库
	 * @param:@param request
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = "/addressComprehensive")
//	public String addressComprehensive(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Monitor monitor = (Monitor) session.getAttribute("m");// 登陆后获得该对象
//		comprehensiveServiceImpl.insertScore(monitor);
//		return "monitor_comprehensive";
//	}

	/**
	 * 
	 * @Title: downloadComprehensive
	 * @Description: TODO(这里用一句话描述这个方法的作用) 将数据库中的数据下载为Excel文件
	 * @param:@param request
	 * @param:@param response
	 * @param:@return
	 * @param:@throws Exception (参数)
	 * @return:String(返回类型)
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadComprehensive")
	public String downloadComprehensive(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Monitor monitor = (Monitor) session.getAttribute("m");// 登陆后获得该对象
		comprehensiveServiceImpl.insertScore(monitor);
		comprehensiveServiceImpl.downloadExcel(response, monitor);
		return "monitor_comprehensive";
	}
}
