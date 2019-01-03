package com.bigdata.ant.apply.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:ApplyDaoImpl
 * @Description:TODO（报名活动页面功能）
 * @Author 成琼
 * @Date:2018年12月24日
 *
 *
 */
@Repository
public class ApplyDaoImpl extends BaseDao<ActivityJoin, Integer> {

	public ApplyDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: saveActivityJoinPerson
	 * @Description: TODO(存储ActivityJoin)
	 * @param:@param stage ActivityStage的id
	 * @param:@param student 对象
	 * @param:@param teamName (参数) 团队名
	 * @return:void(返回类型)
	 */
	public void saveActivityJoinPerson(ActivityStage stage, Student student, String teamName) {
		ActivityJoin aj = new ActivityJoin();
		aj.setActivityStage(stage);
		aj.setStudent(student);
		aj.setTeamName(teamName);
		try {
			save(aj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
