package com.whut.lab.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 具体的课程表
 * @author xuan
 *
 */
@Entity
@Table(name = "course")
public class Course extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626130603422321851L;

	private int id;
	
	private String name;
	
	private Set<Student> students;
	private Set<Teacher> teachers;
	
	
	public Course() {
		super();
	}
	public Course(int id, String name, Set<Student> students,
			Set<Teacher> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
		this.teachers = teachers;
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
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "courses")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "courses")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", students=" + students
				+ ", teachers=" + teachers + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getStudents()="
				+ getStudents() + ", getTeachers()=" + getTeachers() + "]";
	}
	
	
}
