/**
 * @Title:StudentPhotoDaoImpl.java
 * @Package:com.bigdata.ant.publish.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月26日
 */
package com.bigdata.ant.publish.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:StudentPhotoDaoImpl
 * @Description:TODO（更换学生头像）
 * @Author 成琼
 * @Date:2018年12月26日
 *
 *
 */
@Repository
public class StudentPhotoDaoImpl extends BaseDao<Student, Integer> {

	/**
	 * 创建一个新的实例 StudentPhotoDaoImpl.
	 *
	 */
	public StudentPhotoDaoImpl() {
		// TODO Auto-generated constructor stub
	}
/**
 * 
* @Title: updateStudent  
* @Description: TODO(更换学生头像) 
* @param:@param s (参数)
* @return:void(返回类型)
 */
	public void updateStudent(Student s) {
		try {
			update(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
