package com.jwt.entity;

public class AuthenticationRequest {

	
	
	private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public AuthenticationRequest() {
		super();
	}
    
}
