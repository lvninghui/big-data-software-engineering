package com.bigdata.ant.activity.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.activity.dao.ShowActivityDetailDaoImpl;
import com.bigdata.ant.activity.dao.ShowActivityStageDaoImpl;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.ActivityStage;

@Service
@Transactional(readOnly = true)
public class ShowActivityDetailServiceImpl {
	@Resource
	private ShowActivityDetailDaoImpl showActivityDetailDaoImpl;

	@Resource
	private ShowActivityStageDaoImpl showActivityStageDaoImpl;

	public Activity getActivityDetail(int actId) {
		Activity activity = this.showActivityDetailDaoImpl.getActivity(actId);
		return activity;
	}

	public ActivityStage getActivityStage(int actId) {
		ActivityStage astage = this.showActivityStageDaoImpl.getActivityStage(actId);
		return astage;
	}
}
