package com.oupp.bank.request;

import lombok.Data;

@Data
public class UserRequest {

	private Integer userId;
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private String address;
	private String aadharNumber;
	private Integer amount;
	private Integer sourceAccountNum;
	private Integer destinationAccountNum;

	private Integer accountNumber;
	private String accountType;
	private Integer balance;
}
