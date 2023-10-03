package com.sri.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.user.User;

public interface UserRepo extends JpaRepository<User, Integer> {


}
