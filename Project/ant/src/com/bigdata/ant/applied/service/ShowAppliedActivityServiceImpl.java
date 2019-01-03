package com.bigdata.ant.applied.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.applied.dao.ShowAppliedActivityDaoImpl;
import com.bigdata.ant.entity.Activity;
@Service
@Transactional(readOnly=true)
public class ShowAppliedActivityServiceImpl {
	@Resource
	private ShowAppliedActivityDaoImpl showAppliedActivityDaoImpl;
	
	public List<Activity> listAppliedActsWithNotBegin(String stuId){
		List<Activity> appliedActsNotBegin = this.showAppliedActivityDaoImpl.listAppliedActsWithNotBegin(stuId);
		return appliedActsNotBegin;
	}
	public List<Activity> listAppliedActsOnHolding(String stuId){
		List<Activity> appliedActsOnHolding = this.showAppliedActivityDaoImpl.listAppliedActsOnHolding(stuId);
		return appliedActsOnHolding;
	}
	
	public List<Activity> listAppliedActsWithAlreadyEnd(String stuId){
		List<Activity> appliedActsWithAlreadyEnd = this.showAppliedActivityDaoImpl.listAppliedActsWithAlreadyEnd(stuId);
		return appliedActsWithAlreadyEnd;
	}
	
}
