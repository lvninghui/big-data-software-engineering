package com.bigdata.ant.email.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.MD5Util;

/**
 * 
 * @ClassName:UpdatePwdDaoImpl
 * @Description:更改密码
 * @Author xujunmei
 * @Date:2018年12月10日
 *
 */
@Repository
public class UpdatePwdDaoImpl extends BaseDao<Student, Integer> {

	/**
	 * 
	 * @Title: UpdatePwd
	 * @Description: 修改密码
	 * @param:@param hql
	 * @param:@param email
	 * @param:@param pwd (参数)
	 * @return:void(返回类型)
	 *
	 * @param hql
	 * @param email
	 * @param pwd
	 */
	public void UpdatePwd(String email, String pwd) {
		String hql = "from Student s where s.email = ?0";
		String pass = MD5Util.encode2hex(pwd);
		try {
			Student s = this.findOne1(hql, email);
			s.setPassword(pass);
			this.save(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
