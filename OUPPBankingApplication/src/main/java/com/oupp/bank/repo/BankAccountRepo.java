package com.oupp.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.bank.entity.BankAccount;

public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

	Optional<BankAccount> findByAccountNumber(Integer accountNumber);

}
