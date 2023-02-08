package com.legato.MemberRegistrationPortal.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@Entity
public class Claim {
	@Id
	@GeneratedValue
	private int claimId;
	private int userId;
	private long claimToken;
	private LocalDate claimDate;
	private String email;
	private String mem_name;
	private Date mem_dob;
	private Date dt_admission;
	private Date dt_discharge;
	private String provider_name;
	private int total_bill;

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getClaimToken() {
		return claimToken;
	}

	public void setClaimToken(long claimToken) {
		this.claimToken = claimToken;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public Date getMem_dob() {
		return mem_dob;
	}

	public void setMem_dob(Date mem_dob) {
		this.mem_dob = mem_dob;
	}

	public Date getDt_admission() {
		return dt_admission;
	}

	public void setDt_admission(Date dt_admission) {
		this.dt_admission = dt_admission;
	}

	public Date getDt_discharge() {
		return dt_discharge;
	}

	public void setDt_discharge(Date dt_discharge) {
		this.dt_discharge = dt_discharge;
	}

	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

	public int getTotal_bill() {
		return total_bill;
	}

	public void setTotal_bill(int total_bill) {
		this.total_bill = total_bill;
	}

}
