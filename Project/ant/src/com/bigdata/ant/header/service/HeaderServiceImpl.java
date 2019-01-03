/**
 * @Title:HeaderService.java
 * @Package:com.bigdata.ant.header.service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月5日
 */
package com.bigdata.ant.header.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.header.dao.HeaderDaoImpl;

/**
 * @ClassName:HeaderService
 * @Description:TODO（根据关键字查找活动名称）
 * @Author 成琼
 * @Date:2018年12月5日
 *
 */
@Service
@Transactional(readOnly = true)
public class HeaderServiceImpl {
	@Resource
	private HeaderDaoImpl headerDao;

	/**
	 * 
	 * @Title: findActivitiesNames
	 * @Description: TODO(根据关键字查找活动名称)
	 * @param:@param keyword
	 * @param:@return
	 * @param:@throws SQLException (关键字)
	 * @return:List<Object[]>(活动名称的list集合)
	 */
	public List<Object[]> findActivitiesNames(String keyword) throws SQLException {
		List<Object[]> list = headerDao.findActivitiesNames(keyword);
		return list;
	}

}
