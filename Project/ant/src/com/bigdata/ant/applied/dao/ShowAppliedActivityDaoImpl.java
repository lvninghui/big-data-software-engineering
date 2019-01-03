package com.bigdata.ant.applied.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;
@Repository
public class ShowAppliedActivityDaoImpl extends BaseDao<Student,Integer> {

	public List<Activity> listAppliedActsWithNotBegin(String stuId){
		String hql = "from Student where id=?0";
		Object[] obj = {stuId};
		List<Activity> actsNotBegin = new ArrayList<Activity>();
		try {
			Student student = this.findOne(hql, obj);
			for(ActivityJoin activityJoin:student.getJoinedActivities()) {
				ActivityStage activityStage = activityJoin.getActivityStage();
				Activity activity = activityStage.getActivity();
				Date holdBegin = activity.getHoldBegin();
				Date date = new Date();
				if(date.compareTo(holdBegin)<0) {
					actsNotBegin.add(activity);
				}else {
					continue;
				}
			}
			return actsNotBegin;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Activity> listAppliedActsWithAlreadyEnd(String stuId){
		String hql = "from Student where id=?0";
		Object[] obj = {stuId};
		List<Activity> actsAlreadyEnd = new ArrayList<Activity>();
		try {
			Student student = this.findOne(hql, obj);
			for(ActivityJoin activityJoin:student.getJoinedActivities()) {
				ActivityStage activityStage = activityJoin.getActivityStage();
				Activity activity = activityStage.getActivity();
				Date holdEnd = activity.getHoldEnd();
				Date date = new Date();
				if(date.compareTo(holdEnd)>0) {
					actsAlreadyEnd.add(activity);
				}else {
					continue;
				}
			}
			return actsAlreadyEnd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Activity> listAppliedActsOnHolding(String stuId){
		String hql = "from Student where id=?0";
		Object[] obj = {stuId};
		List<Activity> actsOnHolding = new ArrayList<Activity>();
		try {
			Student student = this.findOne(hql, obj);
			for(ActivityJoin activityJoin:student.getJoinedActivities()) {
				ActivityStage activityStage = activityJoin.getActivityStage();
				Activity activity = activityStage.getActivity();
				Date holdBegin = activity.getHoldBegin();
				Date holdEnd = activity.getHoldEnd();
				Date date = new Date();
				if(date.compareTo(holdBegin)>=0&&date.compareTo(holdEnd)<=0) {
					actsOnHolding.add(activity);
				}else {
					continue;
				}
			}
			return actsOnHolding;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
