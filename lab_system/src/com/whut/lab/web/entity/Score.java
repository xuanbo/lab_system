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

/**
 * 学生在某次实验中的分数表
 * @author xuan
 *
 */
@Entity
@Table(name = "score")
public class Score extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5084145095195974867L;

	private int id;
	
	private int grade;
	
	private String mark;
	
	private Student student;
	private LabActivity labActivity;
	
	
	public Score() {
		super();
	}
	public Score(int id, int grade, String mark, Student student,
			LabActivity labActivity) {
		super();
		this.id = id;
		this.grade = grade;
		this.mark = mark;
		this.student = student;
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
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "scoreStudent" ,
	joinColumns = { @JoinColumn( name ="sorceId" )},
	inverseJoinColumns = { @JoinColumn( name = "studentId") })
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "scoreLabActivity" ,
	joinColumns = { @JoinColumn( name ="sorceId" )},
	inverseJoinColumns = { @JoinColumn( name = "labActivityId") })
	public LabActivity getLabActivity() {
		return labActivity;
	}
	public void setLabActivity(LabActivity labActivity) {
		this.labActivity = labActivity;
	}
	
	
	@Override
	public String toString() {
		return "Score [id=" + id + ", grade=" + grade + ", mark=" + mark
				+ ", student=" + student + ", labActivity=" + labActivity
				+ ", getGrade()=" + getGrade() + ", getMark()=" + getMark()
				+ ", getStudent()=" + getStudent() + ", getLabActivity()="
				+ getLabActivity() + "]";
	}
	
	
}
