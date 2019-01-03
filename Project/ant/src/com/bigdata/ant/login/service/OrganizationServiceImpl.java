package com.bigdata.ant.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.login.dao.OrganizationDaoImpl;

/**
 * 
 * @ClassName:OrganizationServiceImpl
 * @Description:组织者登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Service
@Transactional(readOnly = false)
public class OrganizationServiceImpl {

	@Resource
	private OrganizationDaoImpl organizationDaoImpl;

	/**
	 * 
	 * @Title: getOrgByIdAndPwd
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
	public boolean getOrgByEmailAndPwd(String email, String pwd) {
		if (this.organizationDaoImpl.getOrgByEmailAndPwd(email, pwd)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getOrgByEmail
	 * @Description: 是否存在邮箱
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public boolean getOrgByEmail(String email) {
		if (this.organizationDaoImpl.getOrgByEmail(email)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: FindName
	 * @Description: 查找用户名
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:Organization(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public Organization FindName(String email) {
		return this.organizationDaoImpl.SearchName(email);
	}
}
