/**
 * @Title:DeleteServiceImpl.java
 * @Package:com.bigdata.ant.editactivity.Service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月27日
 */
package com.bigdata.ant.editactivity.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.editactivity.Dao.DeleteDaoImpl;
import com.bigdata.ant.editactivity.Dao.DisplayDaoImpl;
import com.bigdata.ant.entity.Activity;

/**
 * @ClassName:DeleteServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2018年12月27日
 *
 */
@Service
@Transactional(readOnly=false)
public class DeleteServiceImpl {
	@Resource
	private DeleteDaoImpl deleteDaoImpl;
	/**
	* @Title: deleteActivity  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@param activity (参数)
	* @return:void(返回类型)
	*
	 * @param activity
	 */
	public void deleteActivity(Activity activity) {
		this.deleteDaoImpl.deleteActivity(activity);
		
	}
	/**
	* @Title: findActivtyByname  
	* @Description: 根据活动id(String)返回活动对象
	* @param:@param name
	* @return:Activity(返回类型)
	*
	 * @param name
	 * @return
	 */
	public Activity findActivityById(int id) {
		return deleteDaoImpl.findActivityById(id);
	}

}
