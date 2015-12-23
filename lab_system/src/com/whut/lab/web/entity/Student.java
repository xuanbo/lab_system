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

@Entity
@Table(name = "student") 
public class Student extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1741815334561879270L;
	
	private int id;
	private String studentNumber;
	private String name;
	private User user;
	private MajorClass majorClass;
	private Set<Course> courses;
	private Set<Score> scores;
	
	public Student() {
		super();
	}				
	public Student(int id, String studentNumber, String name, User user,
			MajorClass majorClass, Set<Course> courses, Set<Score> scores) {
		super();
		this.id = id;
		this.studentNumber = studentNumber;
		this.name = name;
		this.user = user;
		this.majorClass = majorClass;
		this.courses = courses;
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
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "userStudent" ,
	joinColumns = { @JoinColumn( name = "studentId" )},
	inverseJoinColumns = { @JoinColumn( name = "userId") })
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "studentMajorClass" ,
	joinColumns = { @JoinColumn( name ="studentId" )},
	inverseJoinColumns = { @JoinColumn( name = "majorClassId") })
	public MajorClass getMajorClass() {
		return majorClass;
	}
	public void setMajorClass(MajorClass majorClass) {
		this.majorClass = majorClass;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "studentCourse" ,
	joinColumns = { @JoinColumn( name ="studentId" )},
	inverseJoinColumns = { @JoinColumn( name = "courseId") })
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "student")
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNumber=" + studentNumber
				+ ", majorClass=" + majorClass + ", courses=" + courses
				+ ", getId()=" + getId() + ", getStudentNumber()="
				+ getStudentNumber() + ", getMajorClass()=" + getMajorClass()
				+ ", getCourses()=" + getCourses() + "]";
	}
	
	
}
