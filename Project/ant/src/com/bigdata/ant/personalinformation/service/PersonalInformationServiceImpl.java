/**
 * @Title:PersonalInformationServiceImpl.java
 * @Package:com.bigdata.ant.personalinformation.service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月14日
 */
package com.bigdata.ant.personalinformation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.College;
import com.bigdata.ant.entity.Profession;
import com.bigdata.ant.personalinformation.dao.PersonalInformationDaoImpl;
import com.bigdata.ant.personalinformation.dao.ProfessionInformationDaoImpl;

/**
 * @ClassName:PersonalInformationServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2018年12月14日
 *
 */
@Service
@Transactional(readOnly = false)
public class PersonalInformationServiceImpl {
	@Resource
	private PersonalInformationDaoImpl personalinformationdaoimpl;
	@Resource
	private ProfessionInformationDaoImpl professioninformationdaoimpl;

	/**
	 * @Title: collegeInformation
	 * @Description: 找出所有学院
	 * @param:@return (参数)
	 * @return:List<College>(返回类型)
	 *
	 * @return
	 */
	public List<College> collegeInformation() {
		return this.personalinformationdaoimpl.collegeInformation();
	}

	/**
	 * @Title: professionInformation
	 * @Description: 找出所在学院的所有专业
	 * @param:@param collegeid
	 * @param:@return (参数)
	 * @return:List<Profession>(返回类型)
	 *
	 * @param collegeid
	 * @return
	 */
//	public List<Profession> professionInformation(int collegeid) {
//
//		return professioninformationdaoimpl.professionInformation(collegeid);
//	}

	/**
	* @Title: professionInformationall  
	* @Description: 找出所有专业 
	* @param:@return (参数)
	* @return:List<Profession>(返回类型)
	*
	 * @return
	 */
	public List<Profession> professionInformationall() {
		List<Profession> profession=this.professioninformationdaoimpl.professionInformationall();
		if(profession==null) {
			return null;
		}
			return profession;
	}

}
