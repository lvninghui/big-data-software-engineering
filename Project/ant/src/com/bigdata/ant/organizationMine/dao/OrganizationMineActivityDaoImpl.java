package com.bigdata.ant.organizationMine.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.utils.BaseDao;
import com.bigdata.ant.utils.Page;

/**
 * 
 * @ClassName:OrganizationMineActivityDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月19日
 *
 */
@Repository
public class OrganizationMineActivityDaoImpl extends BaseDao<Activity, Integer> {
	/**
	 * 
	 * @Title: countBeforeTime
	 * @Description: TODO(这里用一句话描述这个方法的作用) 在某一时间之前
	 * @param:@param date
	 * @param:@return (参数)
	 * @return:Long(返回类型)
	 *
	 * @param date
	 * @return
	 */
	public Long countBeforeTime(Organization organization) {
		try {
			String hql = "select count(*) from Activity activity where holdBegin>?0 and organization=?1";
			Date date = new Date();
			Object[] obj = {date,organization};
			
			Long count = findCount(hql, obj);
			return count;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 
	* @Title: countInTime  
	* @Description: TODO(这里用一句话描述这个方法的作用) 得到进行状态下的活动数量
	* @param:@return (参数)
	* @return:int(返回类型)
	*
	 * @return
	 */
	public Long countInTime(Organization organization) {
		try {
			String hql = "select count(*) from Activity activity where holdBegin<=?0 and holdEnd>=?0 and organization=?1";
			Date date = new Date();
			Object[] obj = {date,organization};
			
			Long count = findCount(hql, obj);
			return count;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 
	* @Title: countAfterTime  
	* @Description: TODO(这里用一句话描述这个方法的作用) 得到已完成的活动数
	* @param:@return (参数)
	* @return:int(返回类型)
	*
	 * @return
	 */
	public Long countAfterTime(Organization organization) {
		try {
			String hql = "select count(*) from Activity activity where holdEnd<?0 and organization=?1";
			Date date = new Date();
			Object[] obj = {date,organization};
			
			Long count = findCount(hql, obj);
			return count;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	* @Title: findPageByProjection  
	* @Description: TODO(这里用一句话描述这个方法的作用) 分页显示所有的该组织发布的活动
	* @param:@param pageNum
	* @param:@param pageSize
	* @param:@param organization
	* @param:@return (参数)
	* @return:Page<Object[]>(返回类型)
	*
	 * @param pageNum
	 * @param pageSize
	 * @param organization
	 * @return
	 */
	public Page<Object[]> findPageByProjection(int pageNum, int pageSize,Organization organization){
		try {
			String hqlCount="select count(*) from Activity where organization=?0";
			String hqlList="select name,description,holdBegin,holdEnd,id from Activity where organization=?0";
			Object[] params= {organization};
			
			Page<Object[]> page=findPageByProjection(pageNum,pageSize,hqlCount, hqlList,params);
			return page;
		} catch (Exception e) {
			return null;
		}		
	}
	
	/**
	 * 
	* @Title: findPageBeforeTime  
	* @Description: TODO(这里用一句话描述这个方法的作用) 未开始
	* @param:@param pageNum
	* @param:@param pageSize
	* @param:@param organization
	* @param:@return (参数)
	* @return:Page<Object[]>(返回类型)
	*
	 * @param pageNum
	 * @param pageSize
	 * @param organization
	 * @return
	 */
	public Page<Object[]> findPageBeforeTime(int pageNum, int pageSize,Organization organization){
		try {
			String hqlCount="select count(*) from Activity where organization=?0 and holdBegin>?1 ";
			String hqlList="select name,description,holdBegin,holdEnd,id from Activity where organization=?0 and holdBegin>?1";
			Date date=new Date();
			Object[] params= {organization,date};
			
			Page<Object[]> page=findPageByProjection(pageNum,pageSize,hqlCount, hqlList,params);
			return page;
		} catch (Exception e) {
			return null;
		}		
	}
	/**
	 * 
	* @Title: findPageInTime  
	* @Description: TODO(这里用一句话描述这个方法的作用) 进行中
	* @param:@param pageNum
	* @param:@param pageSize
	* @param:@param organization
	* @param:@return (参数)
	* @return:Page<Object[]>(返回类型)
	*
	 * @param pageNum
	 * @param pageSize
	 * @param organization
	 * @return
	 */
	public Page<Object[]> findPageInTime(int pageNum, int pageSize,Organization organization){
		try {
			String hqlCount="select count(*) from Activity where holdBegin<=?0 and holdEnd>=?0 and organization=?1";
			String hqlList="select name,description,holdBegin,holdEnd,id from Activity where holdBegin<=?0 and holdEnd>=?0 and organization=?1";
			Date date=new Date();
			Object[] params= {date,organization};
			
			Page<Object[]> page=findPageByProjection(pageNum,pageSize,hqlCount, hqlList,params);
			return page;
		} catch (Exception e) {
			return null;
		}		
	}
	
	/**
	 * 
	* @Title: findPageAfterTime  
	* @Description: TODO(这里用一句话描述这个方法的作用) 已结束
	* @param:@param pageNum
	* @param:@param pageSize
	* @param:@param organization
	* @param:@return (参数)
	* @return:Page<Object[]>(返回类型)
	*
	 * @param pageNum
	 * @param pageSize
	 * @param organization
	 * @return
	 */
	public Page<Object[]> findPageAfterTime(int pageNum, int pageSize,Organization organization){
		try {
			String hqlCount="select count(*) from Activity where holdEnd<?0 and organization=?1";
			String hqlList="select name,description,holdBegin,holdEnd,id from Activity where holdEnd<?0 and organization=?1";
			Date date=new Date();
			Object[] params= {date,organization};
			
			Page<Object[]> page=findPageByProjection(pageNum,pageSize,hqlCount, hqlList,params);
			System.out.println(page.getList().size());
			return page;
		} catch (Exception e) {
			return null;
		}		
	}
}
