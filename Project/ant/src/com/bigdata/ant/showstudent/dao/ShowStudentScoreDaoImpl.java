package com.bigdata.ant.showstudent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.entity.Comprehensive;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class ShowStudentScoreDaoImpl extends BaseDao<ActivityJoin, Integer> {

	/**
	 * 
	 * @param scoresum 
	 * @Title: findStudentscoreCount
	 * @Description: 通过id查找已加综测分
	 * @param:@param hql
	 * @param:@param params
	 * @return:C
	 *
	 * @param hql
	 * @param params
	 * @return Comprehensive
	 */
	public float getStudentScore(String id) {
		String hql = "from ActivityJoin c where c.student.id = ?0";
		Object[] params = {id };
		float scoresum = 0;
		try {
			List<ActivityJoin> studentscore = this.find(hql, params);	
			for(int i = 0;i<studentscore.size();i++) {
				scoresum =  studentscore.get(i).getActivityStage().getScore()+scoresum;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scoresum;
	}
}
