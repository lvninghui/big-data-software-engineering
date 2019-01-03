package com.bigdata.ant.participationlist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.ActivityJoin;
import com.bigdata.ant.participationlist.dao.ShowParticipationListDaoImpl;
import com.bigdata.ant.participationlist.dao.updatePaticipationListDaoImpl;
import com.bigdata.ant.utils.Page;

@Service
@Transactional(readOnly = false)
public class ParticipationListServiceImpl {
	@Resource
	private ShowParticipationListDaoImpl showParticipationListDaoImpl;
	@Resource
	private updatePaticipationListDaoImpl updatePaticipationListDaoImpl;
	
	public Page<Object[]> getParticipation(int num,int activity_id) {
		Page<Object[]> participation = this.showParticipationListDaoImpl.findPageByParticipation(num,8,activity_id);
		return participation;
	}
	public ActivityJoin getActivityJoin(int activity_id,String stuid){
		
		return this.showParticipationListDaoImpl.findActivityjoin(activity_id,stuid);
	}
		
	public void updateparticipation(ActivityJoin stage) {
		
		this.updatePaticipationListDaoImpl.updateStage(stage);
	
	}
	
}
