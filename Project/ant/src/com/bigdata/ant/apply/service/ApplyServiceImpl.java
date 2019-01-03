/**
 * @Title:ApplyServiceImpl.java
 * @Package:com.bigdata.ant.apply.service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月24日
 */
package com.bigdata.ant.apply.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.apply.dao.ActivityDaoImpl1;
import com.bigdata.ant.apply.dao.ActivityStageDaoImpl;
import com.bigdata.ant.apply.dao.ActivitySumApplyDaoImpl;
import com.bigdata.ant.apply.dao.ApplyDaoImpl;
import com.bigdata.ant.apply.dao.StudentDaoImpl1;
import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.entity.Student;

/**
 * @ClassName:ApplyServiceImpl
 * @Description:TODO（报名活动页面的功能）
 * @Author 成琼
 * @Date:2018年12月24日
 *
 *
 */
@Service
@Transactional(readOnly=false)
public class ApplyServiceImpl {
@Resource
  private ApplyDaoImpl applyDaoImpl;
@Resource
  private ActivityStageDaoImpl activityStageDaoImpl;
@Resource
  private StudentDaoImpl1 studentDaoImpl1;
@Resource
private ActivityDaoImpl1 activityDaoImpl1;
@Resource 
private ActivitySumApplyDaoImpl activitySumApplyDaoImpl;
	/**
	 * 创建一个新的实例 ApplyServiceImpl.  
	 *
	 */
	public ApplyServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	* @Title: saveActivityJoin  
	* @Description: TODO(将报名信息添加到activity_join,activity_sum,改变activity中报名人数) 
	* @param:@param stage activityStage的id
	* @param:@param ids  报名学生的学号数组
	* @param:@param teamName 团队名称
	* @param:@return (参数)
	* @return:Boolean(返回类型)
	 */
	public Boolean saveActivityJoin(String stage,String[] ids,String teamName) {
		int stageId=0;
		ActivityStage as=null;
		ActivitySum activitySum = new ActivitySum();
		Student s=null;
		if(stage!=null) {
			stageId=Integer.parseInt(stage);
		}
		if(stageId!=0) {
			//根据stageId查询activityStage
			as=activityStageDaoImpl.findActivityStage(stageId);
		}else {
			return false;
		}
			for(int i=0;i<ids.length;i++) {
				//根据学生id查找学生
				s=studentDaoImpl1.findStudent(ids[i]);
				if(s==null) {
					return false;
				}else {
					//存到activityJoin表
					applyDaoImpl.saveActivityJoinPerson(as,s,teamName);
					//更新报名人数
					if(activityDaoImpl1.updateStudentNumber(as.getActivity().getId())==false) {
						return false;
					}
					activitySum.setStudent(s);
					activitySum.setActivityName(as.getActivity().getName());
					activitySum.setScore(as.getScore());
					activitySum.setType(as.getActivity().getComprehensiveType());
					Date date=as.getActivity().getHoldBegin();
					if(date.getMonth()>=9) {
						activitySum.setYear(date.getYear()+1900+"");
					}else {
						activitySum.setYear(date.getYear()+1900-1+"");
						
					}
					//存到activitySum
					activitySumApplyDaoImpl.saveActivitySum(activitySum);
				}
				
			}
		return true;
		
	}
	//检查这个学生是否已经注册过
	public Boolean checkStudent(String id) {
		Student s=studentDaoImpl1.findStudent(id);
		if(s==null) {
			return false;
		}else {
			return true;
		}
	}

}
