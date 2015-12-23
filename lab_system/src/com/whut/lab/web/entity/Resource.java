package com.whut.lab.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色资源表
 * @author xuan
 *
 */
@Entity
@Table(name = "resource")
public class Resource extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7119926822961629579L;
	
	private int id;	
	private String authority;
	
	private String url;
	
    private Set<Role> roles;

	
    public Resource(int id, String authority, String url, Set<Role> roles) {
		super();
		this.id = id;
		this.authority = authority;
		this.url = url;
		this.roles = roles;
	}   
    public Resource() {
		super();
	}
	
    
    @Id
    @GeneratedValue
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToMany(mappedBy="resources")
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + authority + ", url=" + url
				+ ", role=" + roles + ", getId()=" + getId() + ", getName()="
				+ getAuthority() + ", getUrl()=" + getUrl() + ", getRole()="
				+ getRoles() + "]";
	}
   
}
