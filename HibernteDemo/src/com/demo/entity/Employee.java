package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int empId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(final int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(final String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + this.empId + ", firstName=" + this.firstName + ", lastName=" + this.lastName
				+ ", dob=" + this.dob + ", gender=" + this.gender + "]";
	}

}
