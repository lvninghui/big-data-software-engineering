/**
 * @Title:StudentDaoImpl.java
 * @Package:com.bigdata.ant.apply.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月24日
 */
package com.bigdata.ant.apply.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ActivityStage;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:StudentDaoImpl
 * @Description:TODO（Student类的操作）
 * @Author 成琼
 * @Date:2018年12月24日
 *
 *
 */
@Repository
public class StudentDaoImpl1 extends BaseDao<Student, Integer> {

	public StudentDaoImpl1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: findStudent
	 * @Description: TODO(根据学生id找学生)
	 * @param:@param studentId
	 * @param:@return (参数)
	 * @return:Student(返回类型)
	 */
	public Student findStudent(String studentId) {
		Student s = null;
		try {
			s = get(studentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

}
