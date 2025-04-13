package com.jwt.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.entity.Users;
import com.jwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Users user = userRepository.findByUserName(username);
//		if (user != null) {
//			return org.springframework.security.core.userdetails.User.builder().username(user.getUserName())
//					.password(user.getPassword()).build();
//		}
//		throw new UsernameNotFoundException("User not found with username: " + username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    // Encode the password before returning the UserDetails object
	    String encodedPassword = passwordEncoder.encode("12345678");
        return new org.springframework.security.core.userdetails.User("user", encodedPassword, new ArrayList<>());

	}
}
