package com.whut.lab.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 实验室表
 * @author xuan
 *
 */
@Entity
@Table(name = "labClass")
public class LabClass extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8469442665315938339L;

	private int id;
	
	private String name;
	
	private Set<LabActivity> labActivitys;

	
	public LabClass() {
		super();
	}
	public LabClass(int id, String name, Set<LabActivity> labActivitys) {
		super();
		this.id = id;
		this.name = name;
		this.labActivitys = labActivitys;
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
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "labClass")
	public Set<LabActivity> getLabActivitys() {
		return labActivitys;
	}
	public void setLabActivitys(Set<LabActivity> labActivitys) {
		this.labActivitys = labActivitys;
	}
	
	
	@Override
	public String toString() {
		return "LabClass [id=" + id + ", name=" + name + ", labActivitys="
				+ labActivitys + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getLabActivitys()=" + getLabActivitys() + "]";
	}

	
	
	
	
}
