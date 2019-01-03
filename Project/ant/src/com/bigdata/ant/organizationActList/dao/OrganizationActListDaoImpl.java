package com.bigdata.ant.organizationActList.dao;


import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.Page;

/**
 * 
 * @ClassName:OrganizationActListDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月24日
 *
 */
@Repository
public class OrganizationActListDaoImpl extends BaseDao<Activity, Integer>{
//	public Page<Object[]> listByTime(int pageNum,int pageSize){
//		try {
//			String hqlCount="select count(*) from Activity order by applyBegin desc";
//			String hqlList="select name,description,level,holdBegin,searchType,organization from Activity order by applyBegin desc";
//			Object[] params=null;
//			Page<Object[]> page=findPageByProjection(pageNum,pageSize,hqlCount, hqlList,params);
//			System.out.println("sum");
//			System.out.println("num"+page.getList().get(0));
//			return page;
//		} catch (Exception e) {
//			System.out.println("trycatch");
//			return null;
//		}
//		
//	}
//	public Page<Activity> listAllByTime(int pageNum,int pageSize){
//		try {
//			return findPage(pageNum, pageSize);
//		} catch (Exception e) {
//			return null;
//		}
//	}
	public Page<Activity> listAllByTime(int pageNum,int pageSize){
		try {
			String hqlCount="select count(*) from Activity order by applyBegin desc";
			String hqlList="from Activity order by applyBegin desc";
			Object[] params=null;
			return findPage(pageNum, pageSize, hqlCount, hqlList, params);
		} catch (Exception e) {
			return null;
		}
	}
	public Page<Activity> listAllByHot(int pageNum,int pageSize){
		try {
			String hqlCount="select count(*) from Activity order by studentNumber desc";
			String hqlList="from Activity order by studentNumber desc";
			Object[] params=null;
			return findPage(pageNum, pageSize, hqlCount, hqlList, params);
		} catch (Exception e) {
			return null;
		}
	}
}
