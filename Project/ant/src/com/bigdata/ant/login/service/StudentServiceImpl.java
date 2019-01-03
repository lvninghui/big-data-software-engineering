package com.bigdata.ant.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.login.dao.StudentDaoImpl;

/**
 * 
 * @ClassName:StudentServiceImpl
 * @Description:学生登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Service
@Transactional(readOnly = false)
public class StudentServiceImpl {

	@Resource
	private StudentDaoImpl studentDaoImpl;

	/**
	 * 
	 * @Title: getStuByIdAndPwd
	 * @Description: 验证账号密码是否正确
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
		if (this.studentDaoImpl.getStuByIdAndPwd(id, pwd)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: FindName
	 * @Description: 查找用户名
	 * @param:@param id
	 * @param:@return (参数)
	 * @return:Student(返回类型)
	 *
	 * @param id
	 * @return
	 */
	public Student getStuById(String id) {
		return this.studentDaoImpl.getStuById(id);
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
		if (this.studentDaoImpl.getById(id)) {
			return true;
		} else {
			return false;
		}
	}
}
