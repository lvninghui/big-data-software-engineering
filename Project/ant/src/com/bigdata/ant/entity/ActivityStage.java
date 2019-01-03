package com.bigdata.ant.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @ClassName:ActivityStage
 * @Description:TODO（活动的不同阶段及其加分类）
 * @Author 成琼
 * @Date:2018年11月22日
 *
 */
@Entity
@Table(name = "activity_score")
public class ActivityStage {
	private int id;
	private String stage;
	private float score;
	private Activity activity;
//private Set<Student> students=new HashSet<Student>();
	private Set<ActivityJoin> joinedActivities = new HashSet<ActivityJoin>();

	public ActivityStage() {
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

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

//   @ManyToMany(mappedBy="joinedActivities")
//	public Set<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}
	@ManyToOne
	@JoinColumn(name = "activity_id")
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@OneToMany(mappedBy = "student", targetEntity = ActivityJoin.class, cascade = { CascadeType.ALL })
	public Set<ActivityJoin> getJoinedActivities() {
		return joinedActivities;
	}

	public void setJoinedActivities(Set<ActivityJoin> joinedActivities) {
		this.joinedActivities = joinedActivities;
	}

}
