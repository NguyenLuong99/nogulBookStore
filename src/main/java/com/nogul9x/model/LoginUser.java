package com.nogul9x.model;

public class LoginUser extends  AbstractDTO<LoginUser> {
	private String username;
	private String password;
	private boolean remember;
	private String img;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	public LoginUser(String username,String img) {
		super();
		this.username = username;
		this.img = img;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public LoginUser() {
		super();
	}
	
}
