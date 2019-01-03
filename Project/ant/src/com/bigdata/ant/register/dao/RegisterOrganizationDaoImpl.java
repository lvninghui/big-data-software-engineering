package com.bigdata.ant.register.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class RegisterOrganizationDaoImpl extends BaseDao<Organization,String> {
	public Boolean updateStatus() {
		try {
			String sql="update organization_user set status=?0";
			Object[] obj= {1};
			excuteBySql(sql,obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Organization findOrganizationByEmail(String email) {
		try {
			String sql="from Organization org where email=?0";
			Object[] obj= {email};
			Organization organization=findOne(sql,obj);
			return organization;
		} catch (Exception e) {
			return null;
		}
	}
}
