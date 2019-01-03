/**
 * @Title:ClassIdInformationDaoImpl.java
 * @Package:com.bigdata.ant.personalinformation.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月19日
 */
package com.bigdata.ant.personalinformation.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.ClassInfo;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:ClassIdInformationDaoImpl
 * @Description:修改class_id
 * @Author 吕凝慧
 * @Date:2018年12月19日
 *
 */
@Repository
public class ClassIdInformationDaoImpl extends BaseDao<ClassInfo, Integer> {

	/**
	* @Title: saveClassId  
	* @Description: 修改class_id
	* @param:@param sclass
	* @param:@param sprofession
	* @param:@param sgrade (参数)
	* @return:void(返回类型)
	*
	 * @param sclass
	 * @param sprofession
	 * @param sgrade
	 */
	public ClassInfo saveClassId(String sclass, String sprofession, String sgrade) {
		ClassInfo classinfo=null;
		String hql="from ClassInfo  c where c.classNo=?0 and c.profession.name=?1 and c.grade=?2"; 
		Object[] obj= {sclass,sprofession,sgrade};
		try {
			classinfo=(ClassInfo)this.findOne(hql, obj);
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classinfo;
	}
	
}
