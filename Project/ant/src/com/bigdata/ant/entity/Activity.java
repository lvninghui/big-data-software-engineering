
package com.bigdata.ant.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @ClassName:Activity
 * @Description:TODO（活动类）
 * @Author 成琼
 * @Date:2018年11月22日
 *
 */
@Entity
@Table(name="activity_information")
public class Activity {
private int id;
private String name;
private String description;
private String level;//级别
private Date applyBegin;
private Date applyEnd;
private Date holdBegin;
private Date holdEnd;
private String holdPlace;
private String style;
private String participant;
private String image;
private String searchType;//搜索类型
private String comprehensiveType;//综测类型
private String isInterview;
private Integer studentNumber;
private Organization organization;
private Set<Student> students=new HashSet<Student>();
private Set<ActivityStage> activityStages=new HashSet<ActivityStage>();
	public Activity() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name="student_number")
	public Integer getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}
	@Column(name="apply_begin")
	public Date getApplyBegin() {
		return applyBegin;
	}
	public void setApplyBegin(Date applyBegin) {
		this.applyBegin = applyBegin;
	}
	@Column(name="apply_end")
	public Date getApplyEnd() {
		return applyEnd;
	}
	public void setApplyEnd(Date applyEnd) {
		this.applyEnd = applyEnd;
	}
	@Column(name="hold_begin")
	public Date getHoldBegin() {
		return holdBegin;
	}
	public void setHoldBegin(Date holdBegin) {
		this.holdBegin = holdBegin;
	}
	@Column(name="hold_end")
	public Date getHoldEnd() {
		return holdEnd;
	}
	public void setHoldEnd(Date holdEnd) {
		this.holdEnd = holdEnd;
	}
	@Column(name="hold_place")
	public String getHoldPlace() {
		return holdPlace;
	}
	public void setHoldPlace(String holdPlace) {
		this.holdPlace = holdPlace;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
    @Column(name="search_type")
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	@Column(name="comprehensive_type")
	public String getComprehensiveType() {
		return comprehensiveType;
	}
	public void setComprehensiveType(String comprehensiveType) {
		this.comprehensiveType = comprehensiveType;
	}
	@Column(name="is_interview")
	public String getIsInterview() {
		return isInterview;
	}
	public void setIsInterview(String isInterview) {
		this.isInterview = isInterview;
	}
	@ManyToOne
	@JoinColumn(name="organization_id")
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	@ManyToMany(mappedBy="scanedActivities")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
   @OneToMany(mappedBy="activity",targetEntity=ActivityStage.class,cascade=CascadeType.ALL)
	public Set<ActivityStage> getActivityStages() {
		return activityStages;
	}
	public void setActivityStages(Set<ActivityStage> activityStages) {
		this.activityStages = activityStages;
	}
	
	

}
