/**
 * @Title:SearchController.java
 * @Package:com.bigdata.ant.search.controller
 * @Description:TODO(个人活动列表页查询活动)
 * @Author:Admin
 * @Date:2018年12月10日
 */
package com.bigdata.ant.search.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigdata.ant.search.service.SearchServiceImpl;
import com.google.gson.Gson;

/**
 * @ClassName:SearchController
 * @Description:TODO（个人活动列表页查询活动）
 * @Author 成琼
 * @Date:2018年12月10日
 *
 */
@Controller
public class SearchController {

	@Resource
	private SearchServiceImpl searchServiceImpl;

	public SearchController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: searchActivities
	 * @Description: TODO(跳到活动列表页时，查询热门活动，按参与人数排序分页显示)
	 * @param:@param model
	 * @param:@param pageNo
	 * @param:@return (第几页)
	 * @return:String(跳到活动列表页)
	 */
	@RequestMapping("/beforeSearch")
	public String searchActivities(Model model, @RequestParam("pageNo") int pageNo) {
		List<Object[]> activities = searchServiceImpl.listActivitiesByPopular(pageNo);
		Long count = (searchServiceImpl.findActivityCount());
		int pageNum;
		if (count % 8 == 0) {
			pageNum = (int) (count / 8);
		} else {
			pageNum = (int) (count / 8 + 1);
		}
		System.out.println("pageNo" + pageNo + "pageNum" + pageNum);
		model.addAttribute("activities", activities);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageNum", pageNum);
		return "student_activityclassify";
	}

	/**
	 * 
	 * @Title: searchActivities
	 * @Description: TODO(根据分类查询活动)
	 * @param:@param types
	 * @param:@param response
	 * @param:@param model (所查询的类型)
	 * @return:void(返回类型)
	 */
	@RequestMapping("/search")
	public void searchActivities(@RequestParam("types") Object[] types, HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		System.out.println("hi" + types[0]);
		List<Object[]> activities = searchServiceImpl.listActivities(types);
		Gson gson = new Gson();
		String re = gson.toJson(activities);
		System.out.println(re + "json");
		try {
			response.getWriter().print(re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(activities.size() + "controller查到数据");
		model.addAttribute("activities", activities);
	}

	/**
	 * 
	 * @Title: listActivitiesByName
	 * @Description: TODO(搜索框查找活动)
	 * @param:@param name
	 * @param:@param model
	 * @param:@return (活动名称)
	 * @return:String(返回活动列表页)
	 */
	@RequestMapping("searchByName")
	public String listActivitiesByName(@RequestParam("name") String name, Model model) {
		List<Object[]> activities = searchServiceImpl.listActivitiesByName(name);
		model.addAttribute("activities", activities);

		return "student_activityclassify";

	}
}
