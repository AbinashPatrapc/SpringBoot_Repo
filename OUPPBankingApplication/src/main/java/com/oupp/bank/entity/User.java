package com.oupp.bank.entity;

import com.oupp.bank.request.UserRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="User_Data")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	private String name;
	@Column(length=50)
	private String email;
	private String password;
	@Column(length=10)
	private String mobileNumber;
	private String address;
	@Column(length=20)
	private String aadharNumber;
	
	@JoinColumn(name="accountNumber")
	@OneToOne
	private BankAccount account;

	public User(UserRequest req) {
		this.name=req.getName();
		this.email=req.getEmail();
		this.password=req.getPassword();
		this.mobileNumber=req.getMobileNumber();
		this.address=req.getAddress();
		this.aadharNumber=req.getAadharNumber();
	}
	
	
}
