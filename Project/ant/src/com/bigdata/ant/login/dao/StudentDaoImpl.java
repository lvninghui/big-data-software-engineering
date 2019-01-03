package com.bigdata.ant.login.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.MD5Util;

/**
 * 
 * @ClassName:StudentDaoImpl
 * @Description:学生登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Repository
public class StudentDaoImpl extends BaseDao<Student, Integer> {

	/**
	 * 
	 * @Title: getStuByIdAndPwd
	 * @Description: 验证账户与密码是否正确
	 * @param:@param id
	 * @param:@param pwd
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean getStuByIdAndPwd(String id, String pwd) {
		Student s = null;
		String pass = MD5Util.encode2hex(pwd);
		String hql = "from Student s where s.id = ?0 and s.password = ?1";
		try {
			s = this.findOne1(hql, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getStuById
	 * @Description: 按id查找用户
	 * @param:@param id
	 * @param:@return (参数)
	 * @return:Student(返回类型)
	 *
	 * @param id
	 * @return
	 */
	public Student getStuById(String id) {
		Student s = null;
		String hql = "from Student s where s.id = ?0";
		try {
			s = this.findOne1(hql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 
	 * @Title: getById
	 * @Description: 判断数据库中是否有id
	 * @param:@param id
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param id
	 * @return
	 */
	public boolean getById(String id) {
		Student s = null;
		String hql = "from Student s where s.id = ?0";
		try {
			s = this.findOne1(hql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s != null) {
			return true;
		} else {
			return false;
		}
	}
}
