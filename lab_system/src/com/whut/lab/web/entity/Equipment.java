package com.whut.lab.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * 实验器材表
 * @author xuan
 *
 */
@Entity
@Table(name = "equipment")
public class Equipment extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2360529169468052804L;
	
	private int id;
	private int totalNumber;
	private int lossNumber;
	private String name;
	private String style;
	private Set<LabActivity> labActivitys;
	private Set<LossEquipment> lossEquipments;
	
	public Equipment() {
		super();
	}	 
	public Equipment(int id, int totalNumber, int lossNumber, String name,
			String style, Set<LabActivity> labActivitys,
			Set<LossEquipment> lossEquipments) {
		super();
		this.id = id;
		this.totalNumber = totalNumber;
		this.lossNumber = lossNumber;
		this.name = name;
		this.style = style;
		this.labActivitys = labActivitys;
		this.lossEquipments = lossEquipments;
	}
	

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public int getLossNumber() {
		return lossNumber;
	}
	public void setLossNumber(int lossNumber) {
		this.lossNumber = lossNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "equipments")
	public Set<LabActivity> getLabActivitys() {
		return labActivitys;
	}
	public void setLabActivitys(Set<LabActivity> labActivitys) {
		this.labActivitys = labActivitys;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "equipments")
	public Set<LossEquipment> getLossEquipments() {
		return lossEquipments;
	}
	public void setLossEquipments(Set<LossEquipment> lossEquipments) {
		this.lossEquipments = lossEquipments;
	}
	
	
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", totalNumber=" + totalNumber
				+ ", lossNumber=" + lossNumber + ", name=" + name + ", style="
				+ style + ", labActivitys=" + labActivitys + ", getId()="
				+ getId() + ", getTotalNumber()=" + getTotalNumber()
				+ ", getLossNumber()=" + getLossNumber() + ", getName()="
				+ getName() + ", getStyle()=" + getStyle()
				+ ", getLabActivitys()=" + getLabActivitys() + "]";
	}

	
}
