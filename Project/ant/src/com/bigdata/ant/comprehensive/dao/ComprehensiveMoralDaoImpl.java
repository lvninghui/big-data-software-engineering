package com.bigdata.ant.comprehensive.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.MoralScore;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:ComprehensiveMoralDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）获得和品德成绩相关数据库内容
 * @Author wangmengzhen
 * @Date:2018年12月26日
 *
 */
@Repository
public class ComprehensiveMoralDaoImpl extends BaseDao<MoralScore, String>{
	
	/**
	 * 
	* @Title: getMoralScore  
	* @Description: TODO(这里用一句话描述这个方法的作用) 通过学号获得该学生的品德成绩
	* @param:@param id
	* @param:@return (参数)
	* @return:float(返回类型)
	*
	 * @param id
	 * @return
	 */
	public float getMoralScore(String id) {
		try {
			MoralScore moralScore=get(id);
			return (float)moralScore.getMoralScore();
		} catch (Exception e) {
			return 0;
		}
		
	}
}
