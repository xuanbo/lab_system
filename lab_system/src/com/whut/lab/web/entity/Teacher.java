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
@Table(name = "teacher")
public class Teacher extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7901130514092264772L;
	
	private int id;
	
	private String teacherNumber;
	private String name;
	
	private User user;
	private Set<Course> courses;
	private Set<MajorClass> majorClasses;
	private Set<LabActivity> labActivities;
	private Set<TeachProgram> teachPrograms;
	
	public Teacher() {
		super();
	}
	public Teacher(int id, String teacherNumber, String name, User user,
			Set<Course> courses, Set<MajorClass> majorClasses,
			Set<LabActivity> labActivities, Set<TeachProgram> teachPrograms) {
		super();
		this.id = id;
		this.teacherNumber = teacherNumber;
		this.name = name;
		this.user = user;
		this.courses = courses;
		this.majorClasses = majorClasses;
		this.labActivities = labActivities;
		this.teachPrograms = teachPrograms;
	}


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTeacherNumber() {
		return teacherNumber;
	}
	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "userTeacher" ,
	joinColumns = { @JoinColumn( name = "teacherId" )},
	inverseJoinColumns = { @JoinColumn( name = "userId") })
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "teacherCourseMajor" ,
	joinColumns = { @JoinColumn( name ="teacherId" )},
	inverseJoinColumns = { @JoinColumn( name = "courseId") })
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "teacherCourseMajor" ,
	joinColumns = { @JoinColumn( name ="teacherId" )},
	inverseJoinColumns = { @JoinColumn( name = "majorClassId") })
	public Set<MajorClass> getMajorClasses() {
		return majorClasses;
	}
	public void setMajorClasses(Set<MajorClass> majorClasses) {
		this.majorClasses = majorClasses;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher")
	public Set<LabActivity> getLabActivities() {
		return labActivities;
	}
	public void setLabActivities(Set<LabActivity> labActivities) {
		this.labActivities = labActivities;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher")
	public Set<TeachProgram> getTeachPrograms() {
		return teachPrograms;
	}
	public void setTeachPrograms(Set<TeachProgram> teachPrograms) {
		this.teachPrograms = teachPrograms;
	}
	
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherNumber=" + teacherNumber
				+ ", name=" + name + ", user=" + user + ", courses=" + courses
				+ ", majorClasses=" + majorClasses + ", labActivities="
				+ labActivities + ", teachPrograms=" + teachPrograms
				+ ", getId()=" + getId() + ", getTeacherNumber()="
				+ getTeacherNumber() + ", getName()=" + getName()
				+ ", getUser()=" + getUser() + ", getCourses()=" + getCourses()
				+ ", getMajorClasses()=" + getMajorClasses()
				+ ", getLabActivities()=" + getLabActivities()
				+ ", getTeachPrograms()=" + getTeachPrograms() + "]";
	}

	
}
