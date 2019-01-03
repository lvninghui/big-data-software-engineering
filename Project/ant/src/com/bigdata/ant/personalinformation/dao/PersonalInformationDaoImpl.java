/**
 * @Title:PersonalInformationDaoImpl.java
 * @Package:com.bigdata.ant.personalinformation.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月14日
 */
package com.bigdata.ant.personalinformation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.College;
import com.bigdata.ant.entity.Profession;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:PersonalInformationDaoImpl
 * @Description:查询所有学院
 * @Author 吕凝慧
 * @Date:2018年12月14日
 *
 */
@Repository
public class PersonalInformationDaoImpl extends BaseDao<College, Integer> {
	// 查询所有学院
	public List<College> collegeInformation() {
		String hql = "from College";
		List<College> studentcollege = null;
		try {
			studentcollege = this.findAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentcollege;

	}

	/**
	 * @Title: find
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param hql
	 * @param:@param collegeid
	 * @param:@return (参数)
	 * @return:List<College>(返回类型)
	 *
	 * @param hql
	 * @param collegeid
	 * @return
	 */
	private List<College> find(String hql, int collegeid) {
		// TODO Auto-generated method stub
		return null;
	}

}
