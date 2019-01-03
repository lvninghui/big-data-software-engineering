package com.bigdata.ant.participationlist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.Page;

@Repository
public class ShowParticipationListDaoImpl extends BaseDao<ActivityJoin, Integer>{
	/**
	 * 
	* @Title: findPageParticipation  
	* @Description: 分页显示所有的该活动的参与者
	* @param:@param pageNum
	* @param:@param pageSize
	* @param:@param activity_id
	* @param:@return (参数)
	* @return:Page<Object[]>
	*
	 * @param pageNum
	 * @param pageSize
	 * @param activity_id
	 * @return
	 */	
	public Page<Object[]> findPageByParticipation(int pageNum, int pageSize,int activity_id){
		String hqlCount="select count(*) from ActivityJoin aj where aj.activityStage.activity.id = ?0";

		String hqlList="select aj.student,aj.activityStage.stage from ActivityJoin aj where aj.activityStage.activity.id = ?0";

		Object[] params= {activity_id};
		
		try {
			Page<Object[]> page=findPageByProjection(pageNum,pageSize,hqlCount, hqlList,params);
			return page;
		} catch (Exception e) {
			return null;
		}	
	}
	
	public ActivityJoin findActivityjoin(int activity_id,String stuid) {
		String hql = "from ActivityJoin ajj where ajj.activityStage.activity.id = ?0 and ajj.student.id = ?1";
		Object[] params= {activity_id,stuid};
		ActivityJoin stage = new ActivityJoin();
		try {
			stage = this.findOne(hql,params);
			return stage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		

}
