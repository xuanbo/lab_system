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
@Table(name = "labAdmin")
public class LabAdmin extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2743633735064040264L;
	
	private int id;
	private String labAdminNumber;
	
	private User user;

	
	public LabAdmin() {
		super();
	}
	public LabAdmin(int id, String labAdminNumber, User user) {
		super();
		this.id = id;
		this.labAdminNumber = labAdminNumber;
		this.user = user;
	}

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabAdminNumber() {
		return labAdminNumber;
	} 
	public void setLabAdminNumber(String labAdminNumber) {
		this.labAdminNumber = labAdminNumber;
	}

	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "userLabAdmin" ,
	joinColumns = { @JoinColumn( name ="labAdminId" )},
	inverseJoinColumns = { @JoinColumn( name = "userId") })
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "LabAdmin [id=" + id + ", labAdminNumber=" + labAdminNumber
				+ ", user=" + user + ", getId()=" + getId()
				+ ", getLabAdminNumber()=" + getLabAdminNumber()
				+ ", getUser()=" + getUser() + "]";
	}

	
	
	
}
