/**
 * @Title:SearchDaoImpl.java
 * @Package:com.bigdata.ant.search.dao
 * @Description:TODO(活动列表页查询活动)
 * @Author:成琼
 * @Date:2018年12月10日
 */
package com.bigdata.ant.search.dao;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.utils.BaseDao;

/**
 * @ClassName:SearchDaoImpl
 * @Description:TODO（活动列表页查询活动）
 * @Author 成琼
 * @Date:2018年12月10日
 *
 */
@Repository
public class SearchDaoImpl extends BaseDao<Activity, Integer> {
	// 按用户选择的类型查询
	/**
	 * 
	 * @Title: listActivities
	 * @Description: TODO(根据活动类型查询活动)
	 * @param:@param types 要查询活动的类型
	 * @param:@return (参数)
	 * @return:List<Object[]>(活动的list集合)
	 */
	public List<Object[]> listActivities(Object[] types) {
		// System.out.println(type_header+" "+type_detail);
		List<Object[]> activities = null;
		String hql = null;
		Date date = new Date();
		// Object[] params=new Object[1];
		if (types[0].equals("全部")) {
			if (types[1].equals("全部")) {
				if (types[2].equals("全部")) {
					hql = "select id,name,image,description,studentNumber from Activity ORDER BY studentNumber desc";
					Object[] params = null;
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (types[2].equals("报名中")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyBegin<?0 and applyEnd>?0 ORDER BY studentNumber desc ";
					}
					if (types[2].equals("进行中")) {
						hql = "select id,name,image,description,studentNumber from Activity where holdBegin<?0 and holdEnd>?0 ORDER BY studentNumber desc";
					}
					if (types[2].equals("已结束")) {
						hql = "select id,name,image,description,studentNumber,holdEnd from Activity where holdEnd<?0 ORDER BY studentNumber desc";
					}
					Object[] params = { date };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				if (types[2].equals("全部")) {
					hql = "select id,name,image,description,studentNumber from Activity where level=?0 ORDER BY studentNumber desc";
					Object[] params = { types[1] };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (types[2].equals("报名中")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyBegin<?0 and applyEnd>?0 and level=?1 ORDER BY studentNumber desc";
					}
					if (types[2].equals("进行中")) {
						hql = "select id,name,image,description,studentNumber from Activity where holdBegin<?0 and holdEnd>?0 and level=?1 ORDER BY studentNumber desc";
					}
					if (types[2].equals("已结束")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyEnd<?0 and level=?1 ORDER BY studentNumber desc";
					}
					Object[] params = { date, types[1] };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			if (types[1].equals("全部")) {
				if (types[2].equals("全部")) {
					hql = "select id,name,image,description,studentNumber from Activity where searchType=?0 ORDER BY studentNumber desc";
					Object[] params = { types[0] };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (types[2].equals("报名中")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyBegin<?0 and applyEnd>?0 and searchType=?1 ORDER BY studentNumber desc";
					}
					if (types[2].equals("进行中")) {
						hql = "select id,name,image,description,studentNumber from Activity where holdBegin<?0 and holdEnd>?0 and searchType=?1 ORDER BY studentNumber desc";
					}
					if (types[2].equals("已结束")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyEnd<?0 and searchType=?1 ORDER BY studentNumber desc";
					}
					Object[] params = { date, types[0] };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} else {
				if (types[2].equals("全部")) {
					hql = "select id,name,image,description,studentNumber from Activity where searchType=?0 and level=?1 ORDER BY studentNumber desc";
					Object[] params = { types[0], types[1] };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (types[2].equals("报名中")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyBegin<?0 and applyEnd>?0 and searchType=?1 and level=?2 ORDER BY studentNumber desc";
					}
					if (types[2].equals("进行中")) {
						hql = "select id,name,image,description,studentNumber from Activity where holdBegin<?0 and holdEnd>?0 and searchType=?1 and level=?2 ORDER BY studentNumber desc";
					}
					if (types[2].equals("已结束")) {
						hql = "select id,name,image,description,studentNumber from Activity where applyEnd<?0 and searchType=?1 and level=?2 ORDER BY studentNumber desc";
					}
					Object[] params = { date, types[0], types[1] };
					try {
						activities = findByProjection(hql, params);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return activities;
	}

	/**
	 * 
	 * @Title: listActivitiesByPopular
	 * @Description: TODO(按报名人数查询热门活动，分页显示)
	 * @param:@param pageNo
	 * @param:@return (第几页)
	 * @return:List<Object[]>(活动的list集合)
	 */
	public List<Object[]> listActivitiesByPopular(int pageNo) {

		String hql = "select id,name,image,description,studentNumber from Activity ORDER BY studentNumber desc";
		Object[] params = null;
		List<Object[]> popularActivities = null;
		try {
			popularActivities = findByProjection(pageNo, 8, hql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return popularActivities;
	}

	/**
	 * 
	 * @Title: findActivityCount
	 * @Description: TODO(查询活动的总数)
	 * @param:@return (参数)
	 * @return:long(活动数量)
	 */
	public long findActivityCount() {
		long count = 0;
		try {
			count = findCount1();
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 
	 * @Title: listActivitiesByName
	 * @Description: TODO(通过活动名称查询活动)
	 * @param:@param name 活动名称
	 * @param:@return (参数)
	 * @return:List<Object[]>(返回类型)
	 */
	public List<Object[]> listActivitiesByName(String name) {
		List<Object[]> activities = null;
		Object[] params = { "%" + name + "%" };
		String hql = "select id,name,image,description,studentNumber,applyBegin from Activity where name like ?0 ORDER BY applyBegin desc ";
		try {
			activities = findByProjection(hql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activities;
	}

	public SearchDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
