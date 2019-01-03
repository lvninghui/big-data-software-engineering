/**
 * @Title:DeleteDaoImpl.java
 * @Package:com.bigdata.ant.editactivity.Dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月27日
 */
package com.bigdata.ant.editactivity.Dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:DeleteDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2018年12月27日
 *
 */
@Repository
public class DeleteDaoImpl extends BaseDao<Activity, Integer> {

	/**
	* @Title: deleteActivity  
	* @Description:删除活动
	* @param:@param activity (参数)
	* @return:void(返回类型)
	*
	 * @param activity
	 */
	public void deleteActivity(Activity activity) {
		if(activity!=null) {
			try {
				this.delete(activity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

	/**
	* @Title: findActivityById  
	* @Description: 根据活动id(String)返回活动对象
	* @param:@param id
	* @param:@return (参数)
	* @return:Activity(返回类型)
	*
	 * @param id
	 * @return
	 */
	public Activity findActivityById(int id) {
		String sql="from Activity a where a.id=?0";
		Object[] obj= {id};
		Activity activity = null;
		try {
			activity = this.findOne(sql,obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activity;
	}

}
