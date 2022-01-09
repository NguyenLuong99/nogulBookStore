package com.nogul9x.model;



public class User extends AbstractDTO<User> {
	private Integer status;
	private String imgUser;
	private String phone;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getImgUser() {
		return imgUser;
	}
	public void setImgUser(String imgUser) {
		this.imgUser = imgUser;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
