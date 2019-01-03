/**
 * @Title:displayServiceImpl.java
 * @Package:com.bigdata.ant.editactivity.Service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月24日
 */
package com.bigdata.ant.editactivity.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.editactivity.Dao.DisplayDaoImpl;
import com.bigdata.ant.entity.Activity;

@Service
@Transactional(readOnly=false)
public class DisplayServiceImpl {
	@Resource
	private DisplayDaoImpl displaydaoimpl;
	/**
	* @Title: findActivtyByname  
	* @Description: 根据活动名称返回活动对象
	* @param:@param name
	* @return:Activity(返回类型)
	*
	 * @param name
	 * @return
	 */
	public Activity findActivtyByname(String name) {
		Activity activity=displaydaoimpl.findActivtyByname(name);
		return  activity;
	}
	/**
	* @Title: findActivtyByname  
	* @Description: 根据活动id(int)返回活动对象
	* @param:@param name
	* @return:Activity(返回类型)
	*
	 * @param name
	 * @return
	 */
	public Activity findActivityById(int iid) {
		try {
			return displaydaoimpl.get(iid);
		} catch (Exception e) {
			return null;
		}
	}
}
