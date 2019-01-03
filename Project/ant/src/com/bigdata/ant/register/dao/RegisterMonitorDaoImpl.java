package com.bigdata.ant.register.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class RegisterMonitorDaoImpl extends BaseDao<Monitor, String> {
	public Boolean updateStatus() {
		try {
			String sql = "update monitor_user set status=?0";
			Object[] obj = { 1 };
			excuteBySql(sql, obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
