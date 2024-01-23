package com.oupp.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oupp.bank.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	 Optional<User> findByAccount_AccountNumber(Integer accountNumber);
	 
	 @Query("SELECT COUNT(*) FROM User WHERE email = :email AND password = :password")
	 public long countByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	 
}
