package com.legato.MemberRegistrationPortal.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String memberId;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private long contactNo;
	private Date dob;
	private String password;
	private String dependentOne;
	private Date dependentOneDob;
	private String dependentTwo;
	private Date dependentTwoDob;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDependentOne() {
		return dependentOne;
	}

	public void setDependentOne(String dependentOne) {
		this.dependentOne = dependentOne;
	}

	public Date getDependentOneDob() {
		return dependentOneDob;
	}

	public void setDependentOneDob(Date dependentOneDob) {
		this.dependentOneDob = dependentOneDob;
	}

	public String getDependentTwo() {
		return dependentTwo;
	}

	public void setDependentTwo(String dependentTwo) {
		this.dependentTwo = dependentTwo;
	}

	public Date getDependentTwoDob() {
		return dependentTwoDob;
	}

	public void setDependentTwoDob(Date dependentTwoDob) {
		this.dependentTwoDob = dependentTwoDob;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
