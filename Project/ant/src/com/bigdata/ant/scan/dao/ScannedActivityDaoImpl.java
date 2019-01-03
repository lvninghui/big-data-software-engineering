package com.bigdata.ant.scan.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class ScannedActivityDaoImpl extends BaseDao<Student, Integer> {

	public List<Activity> findScannedActivityList(String stuId) {
		List<Activity> actList = new ArrayList<Activity>();
		Student student = new Student();
		String hql = "from Student s where id = ?0";
		Object[] obj = { stuId };
		try {
			student = this.findOne(hql, obj);
			actList = student.getScanedActivities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actList;
	}
}
