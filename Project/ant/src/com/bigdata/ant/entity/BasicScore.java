package com.bigdata.ant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @ClassName:BasicScore
 * @Description:TODO（学业基础分的类）
 * @Author 成琼
 * @Date:2018年11月22日
 *
 */
@Entity
@Table(name = "basic_score")
public class BasicScore {
	private String id;
	private String name;
	private double studyScore;

	public BasicScore() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GenericGenerator(name = "assigned-generator", strategy = "assigned")
	@GeneratedValue(generator = "assigned-generator")
	@Column(name = "student_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "student_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "study_score")
	public double getStudyScore() {
		return studyScore;
	}

	public void setStudyScore(double studyScore) {
		this.studyScore = studyScore;
	}

}
