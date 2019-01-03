/**
 * @Title:ApplyController.java
 * @Package:com.bigdata.ant.apply.controller
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月24日
 */
package com.bigdata.ant.apply.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigdata.ant.apply.service.ApplyServiceImpl;
import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.Student;

/**
 * @ClassName:ApplyController
 * @Description:TODO（报名活动页面功能）
 * @Author 成琼
 * @Date:2018年12月24日
 *
 *
 */
@Controller
public class ApplyController {
	@Resource
   private ApplyServiceImpl applyServiceImpl;
	public ApplyController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	* @Title: checkStudent  
	* @Description: TODO(验证此学生是否注册了) 
	* @param:@param studentId 学号
	* @param:@param response (参数)
	* @return:void(返回类型)
	 */
	@RequestMapping("/checkStudent")
	public void checkStudent(@RequestParam("studentId") String studentId,HttpServletResponse response) {
		if(applyServiceImpl.checkStudent(studentId)==true) {
			try {
				response.getWriter().print("ok");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().print("no");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 
	* @Title: applyAcivity  
	* @Description: TODO(保存报名信息) 
	* @param:@param stage
	* @param:@param ids
	* @param:@param teamName
	* @param:@return (参数)
	* @return:String(返回类型)
	 */
	@RequestMapping("/applyActivity")
	public String applyAcivity(@RequestParam("stage") String stage,@RequestParam("activityId") String activityId,@RequestParam("mytext[]") String ids[],@RequestParam("teamName") String teamName,HttpServletRequest request,Model model) {
    HttpSession session=request.getSession();
   Student student= (Student) session.getAttribute("s");
   System.out.println(student.getId());
   model.addAttribute("activityId", activityId);
		if(ids.length==0) {
			//把studentid 换成session里的数据
			String[] ids1= {student.getId()};
	        if(applyServiceImpl.saveActivityJoin(stage,ids1,teamName)==false) {
	        	return "student_applyfail";
	        }
		}else {
			if(applyServiceImpl.saveActivityJoin(stage,ids,teamName)==false) {
				return "student_applyfail";
			}
		}
	   return "student_applysuccessful";
		
	}

}
