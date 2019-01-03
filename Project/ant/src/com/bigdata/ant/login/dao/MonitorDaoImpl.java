package com.bigdata.ant.login.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.MD5Util;

/**
 * 
 * @ClassName:MonitorDaoImpl
 * @Description:班委登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Repository
public class MonitorDaoImpl extends BaseDao<Monitor, String> {

	/**
	 * 
	 * @Title: getMonByIdAndPwd
	 * @Description: 验证账户与密码是否正确
	 * @param:@param email
	 * @param:@param pwd
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param email
	 * @param pwd
	 * @return
	 */
	public boolean getMonByEmailAndPwd(String email, String pwd) {
		Monitor m = null;
		String pass = MD5Util.encode2hex(pwd);
		String hql = "from Monitor m where m.email = ?0 and m.password = ?1";
		try {
			m = this.findOne1(hql, email, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getMonByEmail
	 * @Description:判断email是否存在
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public boolean getMonByEmail(String email) {
		Monitor m = null;
		String hql = "from Monitor m where m.email = ?0";
		try {
			m = this.findOne1(hql, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getMonitor
	 * @Description: 按email找到用户
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:Monitor(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public Monitor getMonitor(String email) {
		String hql = "from Monitor m where m.email = ?0";
		try {
			return this.findOne1(hql, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
