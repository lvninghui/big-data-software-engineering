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
 * @Description:TODO（综测品德类）
 * @Author wangmengzhen
 * @Date:2018年11月22日
 *
 */
@Entity
@Table(name = "moral_score")
public class MoralScore {
	private String id;
	private String name;
	private double moralScore;

	public MoralScore() {
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
	@Column(name = "moral_score")
	public double getMoralScore() {
		return moralScore;
	}

	public void setMoralScore(double moralScore) {
		this.moralScore = moralScore;
	}

}
