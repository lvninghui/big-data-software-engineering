package com.bigdata.ant.activity.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;
/**
 * 
 * @ClassName:ShowActivityDetailDaoImpl
 * @Description:通过主键使用get方法得到Activity对象
 * @Author zhaojiayao
 * @Date:2018年12月10日
 *
 */
@Repository
public class ShowActivityDetailDaoImpl extends BaseDao<Activity, Integer> {
	/**
	 * 
	* @Title: getActivity  
	* @Description: 通过主键使用get方法得到Activity对象
	* @param:@param actId
	* @param:@return (参数)
	* @return:Activity(返回类型)
	*
	 * @param actId
	 * @return
	 */
	public Activity getActivity(int actId) {
		try {
			Activity activity = this.get(actId);
			System.out.println(activity.getName());
			return activity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
