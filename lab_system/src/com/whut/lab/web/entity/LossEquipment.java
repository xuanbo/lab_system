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
 * 材料损耗表
 * @author xuan
 *
 */
@Entity
@Table(name = "lossEquipment")
public class LossEquipment extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7681698962833362696L;
	
	private int id;
	private int lossNumber;
	
	private Set<Equipment> equipments;
	private LabActivity labActivity;

	
	public LossEquipment() {
		super();
	}	
	public LossEquipment(int id, int lossNumber, Set<Equipment> equipments,
			LabActivity labActivity) {
		super();
		this.id = id;
		this.lossNumber = lossNumber;
		this.equipments = equipments;
		this.labActivity = labActivity;
	}


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getLossNumber() {
		return lossNumber;
	}
	public void setLossNumber(int lossNumber) {
		this.lossNumber = lossNumber;
	}

	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "lossEquipmentEquipment" ,
	joinColumns = { @JoinColumn( name ="lossEquipmentId" )},
	inverseJoinColumns = { @JoinColumn( name = "equipmentId") })
	public Set<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "lossEquipmentLabActivity" ,
	joinColumns = { @JoinColumn( name ="lossEquipmentId" )},
	inverseJoinColumns = { @JoinColumn( name = "labActivityId") })
	public LabActivity getLabActivity() {
		return labActivity;
	}
	public void setLabActivity(LabActivity labActivity) {
		this.labActivity = labActivity;
	}

	@Override
	public String toString() {
		return "LossEquipment [id=" + id + ", lossNumber=" + lossNumber
				+ ", labActivity=" + labActivity + ", getId()=" + getId()
				+ ", getLossNumber()=" + getLossNumber()
				+ ", getLabActivity()=" + getLabActivity() + "]";
	}
	
	
	

}
