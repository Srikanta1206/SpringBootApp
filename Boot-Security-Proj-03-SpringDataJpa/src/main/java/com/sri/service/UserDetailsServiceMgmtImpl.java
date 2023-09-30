package com.sri.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sri.repository.IUserRepository;
@Service
public class UserDetailsServiceMgmtImpl implements IServiceMgmt {

	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public String register(com.sri.entity.UserDetails details) {
		//Encode the password taking help form some predefined encoder class
		details.setPwd(encoder.encode(details.getPwd()));
		//performing insert operation
		Integer id=repo.save(details).getId();
		return "User register with user id  :"+id;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadsUserByUserName");
		com.sri.entity.UserDetails details=repo.findByName(username).get();
		User user=new User(details.getName()
				,details.getPwd()
				,details.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		return user;
	}
}
