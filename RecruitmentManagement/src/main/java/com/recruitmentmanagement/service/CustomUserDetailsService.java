package com.recruitmentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UsersService usersService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		final Users users = usersService.getUsersByUsers(username);
		
		if (users == null) {

			throw new UsernameNotFoundException("User not found !!!");				
		}

		UserDetails userDetails = User.withUsername(users.getUserName()).password(users.getPassword()).authorities("USER").build();	
		
		
		
		return userDetails;

	}

}
