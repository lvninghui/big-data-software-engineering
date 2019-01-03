/**
 * @Title:ActivityJoin.java
 * @Package:com.bigdata.ant.entity
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:Admin
 * @Date:2018年12月5日
 */
package com.bigdata.ant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @ClassName:ActivityJoin
 * @Description:TODO（活动参与表）
 * @Author 成琼
 * @Date:2018年12月5日
 *
 */
@Entity
@Table(name = "student_join")
public class ActivityJoin {
	private int id;
	private Student student;
	private ActivityStage activityStage;
	private String teamName;

	public ActivityJoin() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "score_id")
	public ActivityStage getActivityStage() {
		return activityStage;
	}

	public void setActivityStage(ActivityStage activityStage) {
		this.activityStage = activityStage;
	}

	@Column(name = "team_name")
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
