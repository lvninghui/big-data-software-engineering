package com.bigdata.ant.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.login.dao.MonitorDaoImpl;

/**
 * 
 * @ClassName:MonitorServiceImpl
 * @Description:班委登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Service
@Transactional(readOnly = false)
public class MonitorServiceImpl {

	@Resource
	private MonitorDaoImpl monitorDaoImpl;

	/**
	 * 
	 * @Title: getMonByIdAndPwd
	 * @Description: 验证账号密码是否正确
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
		if (this.monitorDaoImpl.getMonByEmailAndPwd(email, pwd)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getMonByEmail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param email
	 * @param:@param pwd
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param email
	 * @param pwd
	 * @return
	 */
	public boolean getMonByEmail(String email) {
		if (this.monitorDaoImpl.getMonByEmail(email)) {
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
		return this.monitorDaoImpl.getMonitor(email);
	}
}
