/**
 * @Title:SaveSInformationServiceImpl.java
 * @Package:com.bigdata.ant.personalinformation.service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月17日
 */
package com.bigdata.ant.personalinformation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.ClassInfo;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.personalinformation.dao.ClassIdInformationDaoImpl;
import com.bigdata.ant.personalinformation.dao.SaveSInformationDaoImpl;

/**
 * @ClassName:SaveSInformationServiceImpl
 * @Description:更新个人信息
 * @Author 吕凝慧
 * @Date:2018年12月17日
 *
 */
@Service
@Transactional(readOnly = false)
public class SaveSInformationServiceImpl {
	@Resource
	private SaveSInformationDaoImpl savesinformationdaoimpl;
	@Resource
	private ClassIdInformationDaoImpl classidinformationdaoimpl;

//	public Student findStu(String id) {
//		Student student=this.savesinformationdaoimpl.findStu(id);
//		return student;
//	}
	public void updateSInf(Student student) {
		this.savesinformationdaoimpl.updateSInf(student);
	}

	/**
	* @Title: saveClassId  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
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
		ClassInfo classinfo=this.classidinformationdaoimpl.saveClassId(sclass,sprofession,sgrade);
		return classinfo;
	}

}
