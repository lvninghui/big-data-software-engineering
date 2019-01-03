/**
 * @Title:DisplayDaoImpl.java
 * @Package:com.bigdata.ant.editactivity.Dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月24日
 */
package com.bigdata.ant.editactivity.Dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class DisplayDaoImpl extends BaseDao<Activity, Integer> {

	/**
	* @Title: findActivtyByname  
	* @Description: 根据活动name返回活动对象
	* @param:@param name
	* @param:@return (参数)
	* @return:Activity(返回类型)
	*
	 * @param name
	 * @return
	 */
	public Activity findActivtyByname(String name) {
		String hql="from Activity a where a.name=?0";
		Object[] obj= {name};
		Activity activity=null;
		try {
			activity=this.findOne(hql,obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activity;
	}

}
