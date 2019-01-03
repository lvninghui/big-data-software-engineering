package com.bigdata.ant.comprehensive.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.BasicScore;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:ComprehensiveStudyDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）获得和学业成绩相关数据库内容
 * @Author wangmengzhen
 * @Date:2018年12月26日
 *
 */
@Repository
public class ComprehensiveStudyDaoImpl extends BaseDao<BasicScore, String>{
	public float getStudyScore(String id) {
		try {
			BasicScore basicScore=get(id);
			return (float)basicScore.getStudyScore();
		} catch (Exception e) {
			return 0;
		}
		
	}
}
