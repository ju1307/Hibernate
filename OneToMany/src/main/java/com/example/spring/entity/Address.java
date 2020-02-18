package com.example.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private Long id;

	@Column(name = "CITY")
	@NotNull
	private String city;

	@Column(name = "PINCODE")
	@NotNull
	private Integer pincode;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	@NotNull
	@JsonIgnore
	private Employee employee;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return this.pincode;
	}

	public void setPincode(final Integer pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + this.id + ", city=" + this.city + ", pincode=" + this.pincode + ", employee="
				+ this.employee + "]";
	}

}
