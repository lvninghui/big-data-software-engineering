package com.bigdata.ant.participationlist.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.participationlist.service.ParticipationListServiceImpl;
import com.bigdata.ant.utils.Page;

/**
 * 
 * @ClassName:ParticipationController
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author hwx
 * @Date:2018年12月19日
 *
 */

@Controller
public class ParticipationController {
	@Resource
	private ParticipationListServiceImpl participationListServiceImpl;
	
	/**
	 * 
	* @Title: showParticipationpage  
	* @Description: TODO(这里用一句话描述这个方法的作用) 显示所有活动对应的参赛者
	* @param:@param request
	* @param:@return (参数)
	* @return:String(返回类型)
	*
	 * @param request
	 * @return
	 */
	@RequestMapping("/toparticipationall")
	public String showParticipationpage(HttpServletRequest request){
		
		
		int activityid = Integer.parseInt(request.getParameter("activityid"));
		String pageNum=request.getParameter("pageNum");
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}else {
			num=Integer.parseInt(pageNum);
		}
		/*得到stage表单*/
		
		/*更新数据库activityStage*/
		Page<Object[]> allparticipation = this.participationListServiceImpl.getParticipation(num,activityid);
		request.setAttribute("participation", allparticipation);
		request.setAttribute("activityid", activityid);
		return "organization_personalstage";
	}
	
	/**
	 * 
	* @Title: showParticipationpage  
	* @Description: TODO(这里用一句话描述这个方法的作用) 显示未开始活动对应的参赛者
	* @param:@param request
	* @param:@return (参数)
	* @return:String(返回类型)
	*
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/toparticipation", method = RequestMethod.POST)
	public String showBeforParticipationpage(HttpServletRequest request,@RequestParam("stuid") String stuid,
		@RequestParam("stustage") String stustage){
		
		/*organization_mine*/
		HttpSession session=request.getSession();
		Organization organization=(Organization) session.getAttribute("o");
		session.setAttribute("o", organization);
		
		int activityid = Integer.parseInt(request.getParameter("activityid"));
		String pageNum=request.getParameter("pageNum");
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}else {
			num=Integer.parseInt(pageNum);
		}
		

		ActivityJoin activityjoin = this.participationListServiceImpl.getActivityJoin(activityid,stuid);
		activityjoin.getActivityStage().setStage(stustage);
		this.participationListServiceImpl.updateparticipation(activityjoin);
		Page<Object[]> participation= this.participationListServiceImpl.getParticipation(num,activityid);
		request.setAttribute("participation", participation);
		request.setAttribute("activityid", activityid);
		return "organization_personalstage";
	}
	
}
