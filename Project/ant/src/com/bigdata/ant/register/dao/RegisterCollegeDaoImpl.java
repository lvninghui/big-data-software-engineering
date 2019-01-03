package com.bigdata.ant.register.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.College;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:RegisterCollegeDaoImpl
 * @Description:TODO（用一句话描述这个类的作用
 * @Author wangmengzhen
 * @Date:2018年12月12日
 *
 */
@Repository
public class RegisterCollegeDaoImpl extends BaseDao<College, Integer> {

	/**
	 * 
	 * @Title: findCollege
	 * @Description: TODO(这里用一句话描述这个方法的作用)查找到所有学院
	 * @param:@return (参数)
	 * @return:List<College>(返回类型)
	 *
	 * @return
	 */
	public List<College> findCollege() {
		try {
			List<College> list = findAll();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
