package com.bigdata.ant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @ClassName:Comprehensive
 * @Description:TODO（综测总分）
 * @Author 成琼
 * @Date:2018年11月22日
 *
 */
@Entity
@Table(name = "student_comprehensive")
public class Comprehensive {
	private String id;
	private String name;
	private float score;

	public Comprehensive() {
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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
