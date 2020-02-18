package com.example.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long studentId;

	@Column(name = "Name", nullable = false)
	private String studentName;

	@Column(name = "Gender", nullable = false)
	private String gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public Long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(final Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(final String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

}
