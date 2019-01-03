package com.bigdata.ant.comprehensive.dao;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Comprehensive;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:ComprehensiveDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）获得和综测成绩相关数据库内容
 * @Author wangmengzhen
 * @Date:2018年12月26日
 *
 */
@Repository
public class ComprehensiveDaoImpl extends BaseDao<Comprehensive, String>{
	public Comprehensive getComprehensive(String id) {
		try {
			return get(id);
		} catch (Exception e) {
			return null;
		}
	}
	public void saveComprehensive(Comprehensive comprehensive) {
		try {
			System.out.println("save"+comprehensive.getId());
			save(comprehensive);
		} catch (Exception e) {
			System.out.println("comprehensiveError");
		}
	}
	public void updateComprehensive(Comprehensive comprehensive) {
		try {
			update(comprehensive);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
