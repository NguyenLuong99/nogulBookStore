package com.nogul9x.model;

import java.util.List;

import com.nogul9x.entity.UserEntity;

public class Role {
	private String email;
	private String password;
	private String fullname;

	List<UserEntity> userRole;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<UserEntity> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserEntity> userRole) {
		this.userRole = userRole;
	}


	
}
