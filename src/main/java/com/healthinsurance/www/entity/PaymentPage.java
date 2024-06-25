package com.healthinsurance.www.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment_page")
@Data
public class PaymentPage 
{
	@Id
	private String userId;
	
	@Column
	private String planType;
	
	@Column
	private String relationType;
	
	@Column
	private String duration;
	
	@Column
	private String insuranceCover;
	
	@Column
	private String interest;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private RegisterationPage register;


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPlanType() {
		return planType;
	}


	public void setPlanType(String planType) {
		this.planType = planType;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getInsuranceCover() {
		return insuranceCover;
	}


	public void setInsuranceCover(String insuranceCover) {
		this.insuranceCover = insuranceCover;
	}


	public String getInterest() {
		return interest;
	}


	public void setInterest(String interest) {
		this.interest = interest;
	}


	public RegisterationPage getRegister() {
		return register;
	}


	public void setRegister(RegisterationPage register) {
		this.register = register;
	}


	public String getRelationType() {
		return relationType;
	}


	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}


	}


	


	





