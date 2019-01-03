/**
 * @Title:EditDaoImpl.java
 * @Package:com.bigdata.ant.editactivity.Dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月26日
 */
package com.bigdata.ant.editactivity.Dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:EditDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2018年12月26日
 *
 */
@Repository
public class EditDaoImpl extends BaseDao<Activity, Integer> {

	/**
	* @Title: updateA  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@param activity (参数)
	* @return:void(返回类型)
	*
	 * @param activity
	 */
	public void updateA(Activity activity) {
		try {
			this.update(activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
