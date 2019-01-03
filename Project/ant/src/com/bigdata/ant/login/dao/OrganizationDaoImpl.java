package com.bigdata.ant.login.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.MD5Util;

/**
 * 
 * @ClassName:OrganizationDaoImpl
 * @Description:组织者登录验证
 * @Author xujunmei
 * @Date:2018年12月12日
 *
 */
@Repository
public class OrganizationDaoImpl extends BaseDao<Organization, Integer> {

	/**
	 * 
	 * @Title: getOrgByIdAndPwd
	 * @Description:验证账户与密码是否正确
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
		Organization o = null;
		String pass = MD5Util.encode2hex(pwd);
		String hql = "from Organization o where o.email = ?0 and o.password = ?1";
		try {
			o = this.findOne1(hql, email, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (o != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getOrgByEmail
	 * @Description: 判断邮箱是否存在
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public boolean getOrgByEmail(String email) {
		Organization o = null;
		String hql = "from Organization o where o.email = ?0";
		try {
			o = this.findOne1(hql, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (o != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: SearchName
	 * @Description: 查找用户名
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:Organization(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public Organization SearchName(String email) {
		Organization o = null;
		String hql = "from Organization o where o.email = ?0";
		try {
			o = this.findOne1(hql, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
