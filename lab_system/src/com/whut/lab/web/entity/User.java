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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户表
 * @author xuan
 *
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4961008633017304630L;

	private int id;
	
	private String name;
	private String password;
	
	private Set<Role> roles;
	private Student student;
	private Teacher teacher;
	private LabAdmin labAdmin;
	
	
	public User() {
		super();
	}
	public User(int id, String name, String password, Set<Role> roles,
			Student student, Teacher teacher,
			LabAdmin labAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.roles = roles;
		this.student = student;
		this.teacher = teacher;
		this.labAdmin = labAdmin;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "userRole" ,
	joinColumns = { @JoinColumn( name ="userId" )},
	inverseJoinColumns = { @JoinColumn( name = "roleId") })
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
	public LabAdmin getLabAdmin() {
		return labAdmin;
	}
	public void setLabAdmin(LabAdmin labAdmin) {
		this.labAdmin = labAdmin;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", roles=" + roles + ", student=" + student + ", teacher="
				+ teacher + ", labAdmin=" + labAdmin + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPassword()="
				+ getPassword() + ", getRoles()=" + getRoles()
				+ ", getStudent()=" + getStudent() + ", getTeacher()="
				+ getTeacher() + ", getLabAdmin()=" + getLabAdmin() + "]";
	}
	
	
}
