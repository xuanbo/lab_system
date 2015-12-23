package com.whut.lab.web.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 教学计划表
 * @author xuan
 *
 */
@Entity
@Table(name = "teachProgram")
public class TeachProgram extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -995657993264781486L;
	
	private int id;
	
	private String name;
	private Date time;
	
	private Set<TeachResource> teachResource;
	private MajorClass majorClass;
	private Teacher teacher;
	
	
	public TeachProgram() {
		super();
	}
	public TeachProgram(int id, String name, Date time,
			Set<TeachResource> teachResource, MajorClass majorClass,
			Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.teachResource = teachResource;
		this.majorClass = majorClass;
		this.teacher = teacher;
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
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "teachProgram")
	public Set<TeachResource> getTeachResource() {
		return teachResource;
	}
	public void setTeachResource(Set<TeachResource> teachResource) {
		this.teachResource = teachResource;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "teachProgramMajorClass" ,
	joinColumns = { @JoinColumn( name ="teachProgramId" )},
	inverseJoinColumns = { @JoinColumn( name = "majorClassId") })
	public MajorClass getMajorClass() {
		return majorClass;
	}
	public void setMajorClass(MajorClass majorClass) {
		this.majorClass = majorClass;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "teachProgramTeacher" ,
	joinColumns = { @JoinColumn( name ="teachProgramId" )},
	inverseJoinColumns = { @JoinColumn( name = "teacherId") })
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	@Override
	public String toString() {
		return "TeachProgram [id=" + id + ", name=" + name + ", time=" + time
				+ ", teachResource=" + teachResource + ", majorClass="
				+ majorClass + ", teacher=" + teacher + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getTime()=" + getTime()
				+ ", getTeachResource()=" + getTeachResource()
				+ ", getMajorClass()=" + getMajorClass() + ", getTeacher()="
				+ getTeacher() + "]";
	}
	
	

}
