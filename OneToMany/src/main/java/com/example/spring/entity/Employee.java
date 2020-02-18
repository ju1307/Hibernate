package com.example.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Long empId;

	@Column(name = "EMPLOYEE_NAME")
	@NotNull
	private String empName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Address> address;

	public Long getEmpId() {
		return this.empId;
	}

	public void setEmpId(final Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(final String empName) {
		this.empName = empName;
	}

	public List<Address> getAddress() {
		return this.address;
	}

	public void setAddress(final List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + this.empId + ", empName=" + this.empName + ", address=" + this.address + "]";
	}

}
