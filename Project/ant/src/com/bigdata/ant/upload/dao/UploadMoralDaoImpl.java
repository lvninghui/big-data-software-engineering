package com.bigdata.ant.upload.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.MoralScore;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:UploadMoralDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月24日
 *
 */
@Repository
public class UploadMoralDaoImpl extends BaseDao<MoralScore, Integer>{
	
	/**
	 * 
	* @Title: addMoralScore  
	* @Description: TODO(这里用一句话描述这个方法的作用) 保存该对象
	* @param:@param moralScore (参数)
	* @return:void(返回类型)
	*
	 * @param moralScore
	 */
	public void addMoralScore(MoralScore moralScore) {
		try {
			save(moralScore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
