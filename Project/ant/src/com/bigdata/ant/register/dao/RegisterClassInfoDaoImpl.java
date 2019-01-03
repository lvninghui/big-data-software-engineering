package com.bigdata.ant.register.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ClassInfo;
import com.bigdata.ant.utils.BaseDao;

@Repository
public class RegisterClassInfoDaoImpl extends BaseDao<ClassInfo,Integer>{
	
	@Resource
	private RegisterProfessionDaoImpl registerProfessionDaoImpl;	
	public ClassInfo getClassInfo(String college,String profession,String grade,String classes) {
		try {
			String sql="from ClassInfo ci where profession=?0 and grade=?1 and classNo=?2";
			Object[] obj= {registerProfessionDaoImpl.findByName(profession),grade,classes};
			ClassInfo classInfo=findOne(sql,obj);
			return classInfo;
		} catch (Exception e) {
			return null;
		}
	}
}
