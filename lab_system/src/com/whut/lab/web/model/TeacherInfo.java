package com.whut.lab.web.model;

import com.whut.lab.web.entity.BaseEntity;

/**
 * 存储教师所教为哪个专业班级所教的科目
 * @author xuan
 *
 */
public class TeacherInfo extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8100474180751080618L;
	
	private String courseName;
	private String majorClassName;
	
	public TeacherInfo() {
		super();
	}

	public TeacherInfo(String courseName, String majorClassName) {
		super();
		this.courseName = courseName;
		this.majorClassName = majorClassName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getMajorClassName() {
		return majorClassName;
	}

	public void setMajorClassName(String majorClassName) {
		this.majorClassName = majorClassName;
	}

	@Override
	public String toString() {
		return "TeacherInfo [courseName=" + courseName + ", majorClassName="
				+ majorClassName + ", getCourseName()=" + getCourseName()
				+ ", getMajorClassName()=" + getMajorClassName() + "]";
	}
	
	
}
