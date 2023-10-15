package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Integer> {
	//based on our requirement we also declare custom method based on our requirement 
}
