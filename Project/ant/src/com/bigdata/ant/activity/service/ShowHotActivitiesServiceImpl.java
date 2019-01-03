package com.bigdata.ant.activity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.activity.dao.ShowHotActivitiesDaoImpl;
import com.bigdata.ant.entity.Activity;
@Service
@Transactional(readOnly=true)
public class ShowHotActivitiesServiceImpl {
	@Resource
	private ShowHotActivitiesDaoImpl showHotActivitiesDaoImpl;
	
	public List<Activity> ListHotActivities(){
		List<Activity> hotActList = this.showHotActivitiesDaoImpl.listHotActivities();
		return hotActList;
	}
}
