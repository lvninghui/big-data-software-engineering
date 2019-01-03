package com.bigdata.ant.register.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:RegisterDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）继承BaseDao，实现注册功能所用到的数据库增删改查
 * @Author wangmengzhen
 * @Date:2018年12月10日
 *
 */
@Repository
public class RegisterStudentDaoImpl extends BaseDao<Student, Integer> {

	/**
	 * 
	 * @Title: findByEmail
	 * @Description: TODO(这里用一句话描述这个方法的作用) 通过邮箱找到该student
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:Student(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public Student findByEmail(String email) {
		try {
			String hql = "from Student student where student.email=?0";
			Object[] obj = { email };
			Student student = findOne(hql, obj);
			return student;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @Title: updateStatus
	 * @Description: TODO(这里用一句话描述这个方法的作用) 更新状态
	 * @param: (参数)
	 * @return:void(返回类型)
	 *
	 */
	public Boolean updateStatus() {
		try {
			String sql = "update student_user student set status=?0";
			Object[] obj = { 1 };
			excuteBySql(sql, obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
