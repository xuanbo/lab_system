package com.whut.lab.web.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 实验状态表
 * @author xuan
 *
 */
@Entity
@Table(name = "labActivity")
public class LabActivity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7274550718941806847L;

	private int id;
	private String state;
	private String begin;
	private String end;
	
	private Teacher teacher;
	private Course course;
	private MajorClass majorClass;
	private LabClass labClass;
	private Set<Equipment> equipments;
	private Set<LossEquipment> lossEquipments;
	private Set<Score> scores;
	
	
	public LabActivity() {
		super();
	}
	public LabActivity(int id, String state, String begin, String end,
			Teacher teacher, Course course, MajorClass majorClass,
			LabClass labClass, Set<Equipment> equipments,
			Set<LossEquipment> lossEquipments, Set<Score> scores) {
		super();
		this.id = id;
		this.state = state;
		this.begin = begin;
		this.end = end;
		this.teacher = teacher;
		this.course = course;
		this.majorClass = majorClass;
		this.labClass = labClass;
		this.equipments = equipments;
		this.lossEquipments = lossEquipments;
		this.scores = scores;
	}
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "labActivityTeacher" ,
	joinColumns = { @JoinColumn( name ="labActivityId" )},
	inverseJoinColumns = { @JoinColumn( name = "teacherId") })
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "labActivityCourse" ,
	joinColumns = { @JoinColumn( name ="labActivityId" )},
	inverseJoinColumns = { @JoinColumn( name = "courseId") })
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "labActivityMajorClass" ,
	joinColumns = { @JoinColumn( name ="labActivityId" )},
	inverseJoinColumns = { @JoinColumn( name = "majorClassId") })
	public MajorClass getMajorClass() {
		return majorClass;
	}
	public void setMajorClass(MajorClass majorClass) {
		this.majorClass = majorClass;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "labActivityLabClass" ,
	joinColumns = { @JoinColumn( name ="labActivityId" )},
	inverseJoinColumns = { @JoinColumn( name = "labClassId") })
	public LabClass getLabClass() {
		return labClass;
	}
	public void setLabClass(LabClass labClass) {
		this.labClass = labClass;
	}
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "labActivityEquipment" ,
	joinColumns = { @JoinColumn( name ="labActivityId" )},
	inverseJoinColumns = { @JoinColumn( name = "equipmentId") })
	public Set<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "labActivity")
	public Set<LossEquipment> getLossEquipments() {
		return lossEquipments;
	}
	public void setLossEquipments(Set<LossEquipment> lossEquipments) {
		this.lossEquipments = lossEquipments;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "labActivity")
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	
	
	@Override
	public String toString() {
		return "LabActivity [id=" + id + ", state=" + state + ", begin="
				+ begin + ", end=" + end + ", teacher=" + teacher + ", course="
				+ course + ", majorClass=" + majorClass + ", labClass="
				+ labClass + ", equipments=" + equipments + ", lossEquipments="
				+ lossEquipments + ", scores=" + scores + ", getId()="
				+ getId() + ", getState()=" + getState() + ", getBegin()="
				+ getBegin() + ", getEnd()=" + getEnd() + ", getTeacher()="
				+ getTeacher() + ", getCourse()=" + getCourse()
				+ ", getMajorClass()=" + getMajorClass() + ", getLabClass()="
				+ getLabClass() + ", getEquipments()=" + getEquipments()
				+ ", getLossEquipments()=" + getLossEquipments()
				+ ", getScores()=" + getScores() + "]";
	}
	
	
}
