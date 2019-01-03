/**
 * @Title:ActivityStageDaoImpl.java
 * @Package:com.bigdata.ant.apply.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月24日
 */
package com.bigdata.ant.apply.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:ActivityStageDaoImpl
 * @Description:TODO（ActivityStage类的操作）
 * @Author 成琼
 * @Date:2018年12月24日
 *
 *
 */
@Repository
public class ActivityStageDaoImpl extends BaseDao<ActivityStage, Integer> {

	/**
	 * 创建一个新的实例 ActivityStageDaoImpl.
	 *
	 */
	public ActivityStageDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: findActivityStage
	 * @Description: TODO(根据id查询ActivityStage)
	 * @param:@param stageId id号
	 * @param:@return (参数)
	 * @return:ActivityStage(返回类型)
	 */
	public ActivityStage findActivityStage(int stageId) {
		ActivityStage as = null;
		try {
			as = get(stageId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return as;

	}
}
