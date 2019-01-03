package com.bigdata.ant.showstudent.service;

/*
 * @ClassName:ShowStudentServiceImpl
 * @Description:个人中心页，顶部展示数据的查询
 * @Author hwx
 * @Date:2018年12月16日
 */
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.entity.Comprehensive;
import com.bigdata.ant.showstudent.dao.ShowActivityDaoImpl;
import com.bigdata.ant.showstudent.dao.ShowStudentActivityDaoImpl;
import com.bigdata.ant.showstudent.dao.ShowStudentScoreDaoImpl;

@Service
@Transactional(readOnly = false)
public class ShowStudentServiceImpl {

	@Resource
	private ShowActivityDaoImpl showActivityDaoImpl;
	@Resource
	private ShowStudentScoreDaoImpl showStudentScoreDaoImpl;
	@Resource
	private ShowStudentActivityDaoImpl showStudentActivityDaoImpl;

	public Long countActivity() {
		Long countAct = this.showActivityDaoImpl.CountActivity();
		return countAct;
	}

	public float FindScore(String id) {
		float nowScore = this.showStudentScoreDaoImpl.getStudentScore(id);
		return nowScore;
	}

	public Long CountStudentactivity(String id) {
		Long stuActivityCount = this.showStudentActivityDaoImpl.CountStudentActivity(id);
		return stuActivityCount;
	}

}
