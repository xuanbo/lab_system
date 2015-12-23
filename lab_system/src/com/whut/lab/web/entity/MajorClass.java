package com.whut.lab.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 专业班级表
 * @author xuan
 *
 */
@Entity
@Table(name = "majorClass")
public class MajorClass extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6825463198353057425L;
	
	private int id;
	private String name;
	private String academy;
	
	private Set<Student> students;
	private Set<Teacher> teachers;
	private Set<TeachProgram> teachPrograms;
	private Set<LabActivity> labActivities;
	
	
	public MajorClass() {
		super();
	}
	public MajorClass(int id, String name, String academy,
			Set<Student> students, Set<Teacher> teachers,
			Set<TeachProgram> teachPrograms, Set<LabActivity> labActivities) {
		super();
		this.id = id;
		this.name = name;
		this.academy = academy;
		this.students = students;
		this.teachers = teachers;
		this.teachPrograms = teachPrograms;
		this.labActivities = labActivities;
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
	
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "majorClass")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "majorClasses")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "majorClass")
	public Set<TeachProgram> getTeachPrograms() {
		return teachPrograms;
	}
	public void setTeachPrograms(Set<TeachProgram> teachPrograms) {
		this.teachPrograms = teachPrograms;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "majorClass")
	public Set<LabActivity> getLabActivities() {
		return labActivities;
	}
	public void setLabActivities(Set<LabActivity> labActivities) {
		this.labActivities = labActivities;
	}
	
	
	@Override
	public String toString() {
		return "MajorClass [id=" + id + ", name=" + name + ", academy="
				+ academy + ", students=" + students + ", teachers=" + teachers
				+ ", teachPrograms=" + teachPrograms + ", labActivities="
				+ labActivities + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getAcademy()=" + getAcademy()
				+ ", getStudents()=" + getStudents() + ", getTeachers()="
				+ getTeachers() + ", getTeachPrograms()=" + getTeachPrograms()
				+ "]";
	}
	
	
}
