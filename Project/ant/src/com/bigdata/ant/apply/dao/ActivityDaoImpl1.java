/**
 * @Title:ActivityDaoImpl1.java
 * @Package:com.bigdata.ant.apply.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月25日
 */
package com.bigdata.ant.apply.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:ActivityDaoImpl1
 * @Description:TODO（Activity的操作）
 * @Author 成琼
 * @Date:2018年12月25日
 *
 *
 */
@Repository
public class ActivityDaoImpl1 extends BaseDao<Activity,Integer> {

	
	public ActivityDaoImpl1() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	* @Title: updateStudentNumber  
	* @Description: TODO(更新报名人数) 
	* @param:@param activityId 活动id号
	* @param:@return (参数)
	* @return:Boolean(返回类型) 是否更新成功
	 */
	public Boolean updateStudentNumber(int activityId) {
		String sql="update activity_information set student_number=(student_number+1) where id=?0";
		Object[] params= {activityId};
		int excuteCount=0;
		try {
			excuteCount=excuteBySql(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(excuteCount==0)
		{
			return false;
		}else {
			return true;
		}
	}

}
