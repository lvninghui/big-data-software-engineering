package com.bigdata.ant.upload.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.BasicScore;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:UploadDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月24日
 *
 */
@Repository
public class UploadDaoImpl extends BaseDao<BasicScore, Integer>{
	
	/**
	 * 
	* @Title: addBasicScore  
	* @Description: TODO(这里用一句话描述这个方法的作用)保存该对象 
	* @param:@param basicScore (参数)
	* @return:void(返回类型)
	*
	 * @param basicScore
	 */
	public void addBasicScore(BasicScore basicScore) {
		try {
			save(basicScore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
