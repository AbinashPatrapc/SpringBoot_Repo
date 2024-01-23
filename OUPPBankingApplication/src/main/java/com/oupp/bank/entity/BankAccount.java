package com.oupp.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "Account")
public class BankAccount {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "account_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer accountNumber;
	private String BankName = "State Bank of India";
	private Integer balance;
	private String accountType;
}
