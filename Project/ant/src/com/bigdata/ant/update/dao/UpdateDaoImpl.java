package com.bigdata.ant.update.dao;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:UpdateDaoImpl
 * @Description:修改参与表
 * @Author xujunmei
 * @Date:2018年12月24日
 *
 */
@Repository
public class UpdateDaoImpl extends BaseDao<ActivitySum, Integer> {

	/**
	 * 
	 * @Title: setAS
	 * @Description: 将list中取出的数据插入到数据库的表中
	 * @param:@param s
	 * @param:@param name
	 * @param:@param score
	 * @param:@param type (参数)
	 * @return:void(返回类型)
	 *
	 * @param s
	 * @param name
	 * @param score
	 * @param type
	 */
	public void setAS(Student s, String name, Float score, String type) {
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		if (month < 9) {
			y = y - 1;
		}
		String year = String.valueOf(y);
		ActivitySum a = new ActivitySum();
		a.setStudent(s);
		a.setActivityName(name);
		a.setScore(score);
		a.setType(type);
		a.setYear(year);
		try {
			this.save(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param:@throws Exception (参数)
	 * @return:void(返回类型)
	 *
	 * @throws Exception
	 */
	public void delete() throws Exception {
		String sql = "delete from activity_sum";
		this.excute(sql);
	}

}
