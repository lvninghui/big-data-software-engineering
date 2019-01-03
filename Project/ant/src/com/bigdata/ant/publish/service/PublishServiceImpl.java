package com.bigdata.ant.publish.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.publish.dao.PublishDaoImpl;
import com.bigdata.ant.publish.dao.StudentPhotoDaoImpl;

/**
 * @ClassName:PublishServiceImpl
 * @Description:TODO（发布活动页面的一些功能）
 * @Author 成琼
 * @Date:2018年12月18日
 *
 *
 */
@Service
@Transactional(readOnly = false)
public class PublishServiceImpl {
	@Resource
	public PublishDaoImpl publishDaoImpl;
	@Resource
	public StudentPhotoDaoImpl studentPhotoDaoImpl;

	/*
	 * public PublishServiceImpl() { // TODO Auto-generated constructor stub }
	 * public Boolean uploadImage(String url) { publishDaoImpl.up return true; }
	 */
	/**
	 * 
	 * @Title: saveActivity
	 * @Description: TODO(保存活动)
	 * @param:@param activity
	 * @param:@param stage
	 * @param:@param score
	 * @param:@return (参数)
	 * @return:Boolean(返回类型)
	 */
	public Boolean saveActivity(Activity activity, String stage, String score, int organizationId) {
		if (publishDaoImpl.saveActivity(activity, stage, Float.parseFloat(score), organizationId)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @Title: listHotActivities
	 * @Description: TODO(查询热门活动)
	 * @param:@return (参数)
	 * @return:List<Object[]>(热门活动的list集合)
	 */
	public List<Object[]> listHotActivities() {
		return publishDaoImpl.listHotActivities();
	}

	/**
	 * 
	 * @Title: updateStudent
	 * @Description: TODO(更改学生头像)
	 * @param:@param s (参数)
	 * @return:void(返回类型)
	 */
	public void updateStudent(Student s) {
		studentPhotoDaoImpl.updateStudent(s);
	}
}
