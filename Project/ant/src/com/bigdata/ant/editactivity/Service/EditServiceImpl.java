/**
 * @Title:EditServlceImpl.java
 * @Package:com.bigdata.ant.editactivity.Service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2018年12月26日
 */
package com.bigdata.ant.editactivity.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.editactivity.Dao.EditDaoImpl;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.personalinformation.dao.SaveSInformationDaoImpl;

/**
 * @ClassName:EditServlceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2018年12月26日
 *
 */
@Service
@Transactional(readOnly = false)
public class EditServiceImpl {
	@Resource
	private EditDaoImpl editdaoimpl;
	/**
	* @Title: updateSInf  
	* @Description: 更新活动信息
	* @param:@param activity (参数)
	* @return:void(返回类型)
	*
	 * @param activity
	 */
	public void updateA(Activity activity) {
		this.editdaoimpl.updateA(activity);
		
	}

}
