package com.bigdata.ant.participationlist.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.Page;

@Repository
public class updatePaticipationListDaoImpl extends BaseDao<ActivityJoin, Integer>{

	/**
	 * 
	* @param ActivityJoin 
	 * @param stuid 
	 * @param allactivityjoin 
	 * @param activityStage 
	 * @Title: editPaticipation 
	* @Description: 编辑分页显示的该活动的活动阶段
	* @param:@param 
	* @param:@param 
	* @param:@param 
	* @param:@return (参数)
	* @param 
	 * @param 
	 * @param 
	 * @return 
	 * @return
	 */	

	
	public void updateStage(ActivityJoin stage) {
		
		try {
			this.update(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
