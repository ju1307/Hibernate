package com.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Address_Table")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long addrId;

	@NotNull
	@Column(name = "Area")
	private String area;

	@NotNull
	@Column(name = "Country")
	private String country;

	@NotNull
	@Column(name = "PinCode")
	private String pincode;

	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Student student;

	public Long getId() {
		return this.addrId;
	}

	public void setId(final Long addrId) {
		this.addrId = addrId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(final String area) {
		this.area = area;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(final String pincode) {
		this.pincode = pincode;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(final Student student) {
		this.student = student;
	}
}
