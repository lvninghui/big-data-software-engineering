/**
 * @Title:ActivitySumApplyDaoImpl.java
 * @Package:com.bigdata.ant.apply.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月25日
 */
package com.bigdata.ant.apply.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:ActivitySumApplyDaoImpl
 * @Description:TODO（ActivitySum操作）
 * @Author 成琼
 * @Date:2018年12月25日
 *
 *
 */
@Repository
public class ActivitySumApplyDaoImpl extends BaseDao<ActivitySum, Integer> {

	/**
	 * 创建一个新的实例 ActivitySumApplyDaoImpl.
	 *
	 */
	public ActivitySumApplyDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: saveActivitySum
	 * @Description: TODO(存储ActivitySum)
	 * @param:@param activitySum (参数)
	 * @return:void(返回类型)
	 */
	public void saveActivitySum(ActivitySum activitySum) {
		try {
			save(activitySum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
