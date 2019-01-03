/**
 * @Title:SaveSInformationDaoImpl.java
 * @Package:com.bigdata.ant.personalinformation.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月17日
 */
package com.bigdata.ant.personalinformation.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:SaveSInformationDaoImpl
 * @Description:根据id找到student
 * @Author 吕凝慧
 * @Date:2018年12月17日
 *
 */
@Repository
public class SaveSInformationDaoImpl extends BaseDao<Student, Integer> {
//	public Student findStu(String id) {
//		String hql="from Student s where s.id=?0";
//		Object[] obj= {id};
//		try {
//			Student stu=this.findOne(hql,obj);
//			return stu;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	public void updateSInf(Student student) {
		try {
			this.update(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
