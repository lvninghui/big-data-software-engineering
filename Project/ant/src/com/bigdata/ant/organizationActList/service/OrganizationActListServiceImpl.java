package com.bigdata.ant.organizationActList.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.organizationActList.dao.OrganizationActListDaoImpl;
import com.bigdata.ant.utils.Page;

/**
 * 
 * @ClassName:OrganizationActListServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月24日
 *
 */
@Service
@Transactional(readOnly = true)
public class OrganizationActListServiceImpl {
	@Resource 
	private OrganizationActListDaoImpl organizationActListDaoImpl;
	
//	public Page<Object[]> listByTime(int pageNum,int pageSize){
//		return organizationActListDaoImpl.listByTime(pageNum, pageSize);
//	}
	public Page<Activity> listAllByTime(int pageNum,int pageSize){
		return organizationActListDaoImpl.listAllByTime(pageNum, pageSize);
	}
	public Page<Activity> listAllByHot(int pageNum,int pageSize){
		return organizationActListDaoImpl.listAllByHot(pageNum, pageSize);
	}
}
