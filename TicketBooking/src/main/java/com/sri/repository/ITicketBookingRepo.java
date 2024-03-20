package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.model.Customer;
@Repository
public interface ITicketBookingRepo extends JpaRepository<Customer, Integer> {

	public boolean findByUsernameAndPassword(String username,String password)throws Exception;
}
