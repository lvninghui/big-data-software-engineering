package com.bigdata.ant.activity.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;
@Repository
public class ShowHotActivitiesDaoImpl extends BaseDao<Activity,Integer> {
	
	public List<Activity> listHotActivities(){
		String hql = "from Activity order by studentNumber DESC";
		Object[] params = { };
		try {
			List<Activity> hotActList = this.find(hql, params);
			return hotActList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
