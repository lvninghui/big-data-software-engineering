/**
 * @Title:ProfessionInformationDaoImpl.java
 * @Package:com.bigdata.ant.personalinformation.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月14日
 */
package com.bigdata.ant.personalinformation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Profession;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:ProfessionInformationDaoImpl
 * @Description:获得所有专业
 * @Author 吕凝慧
 * @Date:2018年12月14日
 *
 */
@Repository
public class ProfessionInformationDaoImpl extends BaseDao<Profession, Integer> {
	public List<Profession> professionInformationall() {
		String hql = "from Profession";
		List<Profession> studentprofession = null;
		try {
			studentprofession = this.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentprofession;
	}

//	public List<Profession> professionInformation(int collegeid) {
//		Object[] obj = { collegeid };
//		String hql = "from Profession p where p.college.id=?0";
//		List<Profession> studentprofession = null;
//		try {
//			studentprofession = this.find(hql, obj);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return studentprofession;
//	}
	
}
