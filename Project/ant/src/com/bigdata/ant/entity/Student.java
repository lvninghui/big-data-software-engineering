package com.bigdata.ant.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @ClassName:Student
 * @Description:TODO（学生类）
 * @Author 成琼
 * @Date:2018年11月22日
 *
 */
@Entity
@Table(name = "student_user")
public class Student {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;
	private ClassInfo classInfo;
	private Integer status;// 状态，0-未激活；1-已激活 ;
	private String validateCode;
	private Date registerTime;
	private String photo;
	private List<Activity> scanedActivities = new ArrayList<Activity>();
	private List<ActivityJoin> joinedActivities = new ArrayList<ActivityJoin>();
	private List<ActivitySum> sumActivities = new ArrayList<ActivitySum>();

	public Student() {
	}

	@Id
	@GenericGenerator(name = "assigned-generator", strategy = "assigned")
	@GeneratedValue(generator = "assigned-generator")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "validate_code")
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	@Column(name = "register_time")
	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	@ManyToMany
	@JoinTable(name = "student_scan", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
	public List<Activity> getScanedActivities() {
		return scanedActivities;
	}

	public void setScanedActivities(List<Activity> scanedActivities) {
		this.scanedActivities = scanedActivities;
	}

	@OneToMany(mappedBy = "student", targetEntity = ActivityJoin.class, cascade = CascadeType.ALL)
	public List<ActivityJoin> getJoinedActivities() {
		return joinedActivities;
	}

	public void setJoinedActivities(List<ActivityJoin> joinedActivities) {
		this.joinedActivities = joinedActivities;
	}

	@OneToMany(mappedBy = "student", targetEntity = ActivitySum.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="id",nullable=true)
	public List<ActivitySum> getSumActivities() {
		return sumActivities;
	}

	public void setSumActivities(List<ActivitySum> sumActivities) {
		this.sumActivities = sumActivities;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}