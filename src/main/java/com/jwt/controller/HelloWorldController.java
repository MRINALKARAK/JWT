package com.jwt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.AuthenticationRequest;
import com.jwt.entity.Users;
import com.jwt.security.JwtUtil;
import com.jwt.service.UsersService;


@RestController
@RequestMapping("/api")
public class HelloWorldController {

	
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	@Autowired
	private UsersService usersService;

	@GetMapping("/Users")
	public List<Users> fetchUser() {
		return usersService.fetchUser();
	}

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	
	@Autowired
    private AuthenticationManager authenticationManager;

	
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());     
        String userName=userDetails.getUsername();
        
        logger.info("User Naem :  "+ userName);

        final String jwt = jwtUtil.generateToken(userName);

        logger.info("JWT token:  "+ jwt);
        return jwt;
    }
	 
}
