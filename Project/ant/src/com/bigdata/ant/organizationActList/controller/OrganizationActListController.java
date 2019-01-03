package com.bigdata.ant.organizationActList.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.organizationActList.service.OrganizationActListServiceImpl;
import com.bigdata.ant.utils.Page;

/**
 * 
 * @ClassName:OrganizationActListController
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月24日
 *
 */
@Controller
public class OrganizationActListController {
	@Resource
	private OrganizationActListServiceImpl organizationActListServiceImpl;
	
	@RequestMapping(value = "/listByTime")
	public String listByTime(HttpServletRequest request) {
		String pageNum=(String) request.getParameter("pageNum");
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}else {
			num=Integer.parseInt(pageNum);
		}
//		Page<Object[]> pageByTime=organizationActListServiceImpl.listByTime(num, 5);
		Page<Activity> pageByTime=organizationActListServiceImpl.listAllByTime(num, 3);
//		System.out.println(pageByTime.getList().size());
		request.setAttribute("pageByTime", pageByTime);
		request.setAttribute("key", "1");
//		System.out.println("key");
		return "organization_activitylist";
	}
	
	@RequestMapping(value = "/listByHot")
	public String listByHot(HttpServletRequest request) {
		String pageNum=(String) request.getParameter("pageNum");
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}else {
			num=Integer.parseInt(pageNum);
		}
		Page<Activity> pageByHot=organizationActListServiceImpl.listAllByHot(num, 3);
		System.out.println(pageByHot.getList().size());
		request.setAttribute("pageByHot", pageByHot);
		request.setAttribute("key", "2");
		return "organization_activitylist";
	}
}
