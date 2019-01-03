package com.bigdata.ant.scan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.scan.dao.ScannedActivityDaoImpl;

@Service
@Transactional(readOnly = true)
public class ScannedActivityServiceImpl {
	@Resource
	private ScannedActivityDaoImpl sannedActivityDaoImpl;

	public List<Activity> findScannedActivityList(String stuId) {
		List<Activity> actList = this.sannedActivityDaoImpl.findScannedActivityList(stuId);
		return actList;
	}
}
