package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int studentId;
	private String studentName;
	private String className;
	private String address;
	public Student() {
		
	}
	public Student(int studentId, String studentName, String className, String address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.className = className;
		this.address = address;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [studentId=").append(studentId).append(", studentName=").append(studentName)
				.append(", className=").append(className).append(", address=").append(address).append("]");
		return builder.toString();
	}
	
	
	
	
}
