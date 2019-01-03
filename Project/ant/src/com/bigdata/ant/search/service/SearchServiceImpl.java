/**
 * @Title:SearchServiceImpl.java
 * @Package:com.bigdata.ant.search.service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月10日
 */
package com.bigdata.ant.search.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bigdata.ant.search.dao.SearchDaoImpl;

/**
 * @ClassName:SearchServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 成琼
 * @Date:2018年12月10日
 *
 */
@Service
@Transactional(readOnly = true)
public class SearchServiceImpl {
	@Resource
	private SearchDaoImpl searchDaoImpl;

	public SearchServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: listActivities
	 * @Description: TODO(通过类型查询活动)
	 * @param:@param types 类型
	 * @param:@return ()
	 * @return:List<Object[]>(活动的list集合)
	 */
	public List<Object[]> listActivities(Object[] types) {
		List<Object[]> activities = searchDaoImpl.listActivities(types);
		return activities;
	}

	public List<Object[]> listActivitiesByPopular(int pageNo) {
		return searchDaoImpl.listActivitiesByPopular(pageNo);
	}

	/**
	 * 
	 * @Title: listActivitiesByName
	 * @Description: TODO(根据名称查找活动)
	 * @param:@param name 活动名称
	 * @param:@return (参数)
	 * @return:List<Object[]>(返回类型)
	 */
	public List<Object[]> listActivitiesByName(String name) {
		return searchDaoImpl.listActivitiesByName(name);

	}

	/**
	 * 
	 * @Title: findActivityCount
	 * @Description: TODO(查询活动的总数)
	 * @param:@return (参数)
	 * @return:Long(活动数量)
	 */
	public Long findActivityCount() {
		return searchDaoImpl.findActivityCount();
	}

}
