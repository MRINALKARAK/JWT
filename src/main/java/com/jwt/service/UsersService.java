package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.entity.Users;
import com.jwt.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository helloWorldRepo;
	
	public List<Users> fetchUser() {
		return helloWorldRepo.findAll();
	}
}
