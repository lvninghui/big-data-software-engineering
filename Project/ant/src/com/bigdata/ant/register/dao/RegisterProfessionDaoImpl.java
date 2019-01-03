package com.bigdata.ant.register.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Profession;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class RegisterProfessionDaoImpl extends BaseDao<Profession, Integer> {
	public Profession findByName(String name) {
		try {
			String sql="from Profession pro where name=?0";
			Object[] obj= {name};
			Profession profession=findOne(sql,obj);
			return profession;
		} catch (Exception e) {
			return null;
		}
	}
	
}
