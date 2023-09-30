package com.sri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.UserDetails;

public interface IUserRepository extends JpaRepository<UserDetails, Integer> {
	
	public Optional<UserDetails> findByName(String name);
}
