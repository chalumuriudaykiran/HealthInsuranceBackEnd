package com.healthinsurance.www.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table		
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginPage {
	@Id
	private String customerId;
	@Column
	private String uname;
	@Column
	private String password;
	
}