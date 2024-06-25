package com.healthinsurance.www.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data

public class RegisterationPage 
{
	@Id
	private String customerId;
	@Column
	private String uname;
	
	@Column
	private String password;

	@Column
	private String email;
	
	@Column
	private String phn;
	
	@Column
	private String gender;
	
	@Column
	private String marital;
	
	@Column
	private String dateofbirth;
	
	@Column
	private String address;

	
}
