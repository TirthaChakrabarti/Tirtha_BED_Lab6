package com.gl.studentManagementSystem.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.studentManagementSystem.entity.User;
import com.gl.studentManagementSystem.repository.UserRepository;
import com.gl.studentManagementSystem.security.MyUserDetails;

public class UserServiceImplementation implements UserDetailsService{

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.getUserByUsername(username); 
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		} 
		
		return new MyUserDetails(user);
	}
}
