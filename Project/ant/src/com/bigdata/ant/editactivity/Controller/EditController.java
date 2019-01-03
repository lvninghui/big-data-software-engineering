/**
 * @Title:EditController.java
 * @Package:com.bigdata.ant.editactivity.Controller
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月26日
 */
package com.bigdata.ant.editactivity.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.editactivity.Service.DisplayServiceImpl;
import com.bigdata.ant.editactivity.Service.EditServiceImpl;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.ActivityStage;

/**
 * @ClassName:EditController
 * @Description:修改组织发布的活动
 * @Author 吕凝慧
 * @Date:2018年12月26日
 *
 */
@Controller
public class EditController {
	@Resource
	private EditServiceImpl editServiceImpl;
	@Resource
	private DisplayServiceImpl displayserviceimpl;
	@RequestMapping(value="/Edit")
	public String editAcitivity(HttpServletRequest request,HttpSession session) {
//		Activity activity=(Activity) session.getAttribute("activity");
		String id=request.getParameter("id");
		System.out.println(id);
		int iid=0;
		if(!(id.equals("")||id==null)){
			iid=Integer.parseInt(id);
		}
		Activity activity=displayserviceimpl.findActivityById(iid);
		//活动名称修改
		String aname=request.getParameter("aname");
		activity.setName(aname);
		//活动简介修改
		String adescription=request.getParameter("adescription");
		activity.setDescription(adescription);
		//时间修改
		String applyBegin=request.getParameter("applybegintime");
		String applyend=request.getParameter("applyendtime");
		String holdon=request.getParameter("holdontime");
		String holdend=request.getParameter("holdendtime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date applybegintime = null;
		java.util.Date applyendtime = null;
		java.util.Date holdontime = null;
		java.util.Date holdendtime = null;
		try {
			applybegintime = sdf.parse(applyBegin);
			applyendtime = sdf.parse(applyend);
			holdontime = sdf.parse(holdon);
			holdendtime = sdf.parse(holdend);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		activity.setApplyBegin(applybegintime);
		activity.setApplyEnd(applyendtime);
		activity.setHoldBegin(holdontime);
		activity.setHoldEnd(holdendtime);
		//活动举办地点修改
		String aplace=request.getParameter("aplace");
		activity.setHoldPlace(aplace);
		//参与范围修改
		String aparticipant=request.getParameter("aparticipant");
		System.out.println(aparticipant);
		activity.setParticipant(aparticipant);
		//参赛形式修改
		String astyle=request.getParameter("astyle");
		activity.setStyle(astyle);
		//活动级别修改
		String alevel=request.getParameter("alevel");
		activity.setLevel(alevel);
		//活动所属类别修改
		String asearchtype=request.getParameter("asearchtype");
		activity.setSearchType(asearchtype);
		//测评所属类别修改
		String acomprehensivetype=request.getParameter("acomprehensivetype");
		activity.setComprehensiveType(acomprehensivetype);
		//当前阶段修改
		String astage=request.getParameter("astage");
		String grade=request.getParameter("grade");
		//判断活动阶段
		Boolean bool=true;
				Set<ActivityStage> activityStageSet= activity.getActivityStages();
				for (ActivityStage activityStage2 : activityStageSet) {
					if(activityStage2.getStage().equals(astage)) {
						activityStage2.setScore(Float.parseFloat(grade));
						bool=false;//不需要增加数据
					}
				}
				if(bool==true) {
					ActivityStage activityStage=new ActivityStage();
					activityStage.setActivity(activity);
					activityStage.setStage(astage);
					activityStage.setScore(Float.parseFloat(grade));
					activityStageSet.add(activityStage);
				}
						
		//是否需要面试修改
		String interview=request.getParameter("interview");
		activity.setIsInterview(interview);
		//把属性更新至数据库
		this.editServiceImpl.updateA(activity);
		session.setAttribute("activity", activity);
		return "organization_mine";
	}	
}
