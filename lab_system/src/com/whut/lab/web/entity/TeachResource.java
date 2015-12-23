package com.whut.lab.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teachResource")
public class TeachResource extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 412140289059039670L;

	private int id;
	
	private String name;
	private String url;
	
	private TeachProgram teachProgram;

	
	public TeachResource() {
		super();
	}
	public TeachResource(int id, String name, String url,
			TeachProgram teachProgram) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.teachProgram = teachProgram;
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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "teachProgramTeachResource" ,
	joinColumns = { @JoinColumn( name ="teachResourceId" )},
	inverseJoinColumns = { @JoinColumn( name = "teachProgramId") })
	public TeachProgram getTeachProgram() {
		return teachProgram;
	}

	public void setTeachProgram(TeachProgram teachProgram) {
		this.teachProgram = teachProgram;
	}
	
	
	@Override
	public String toString() {
		return "TeachResource [id=" + id + ", name=" + name + ", url=" + url
				+ ", teachProgram=" + teachProgram + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getUrl()=" + getUrl()
				+ ", getTeachProgram()=" + getTeachProgram() + "]";
	}

}
