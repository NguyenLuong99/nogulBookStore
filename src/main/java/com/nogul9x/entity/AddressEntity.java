package com.nogul9x.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity implements Serializable {
	private String email;
	private String phone;
	private String provincial;
	private String address;

	@OneToOne(mappedBy = "address")
	private UserEntity user;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvincial() {
		return provincial;
	}
	public void setProvincial(String provincial) {
		this.provincial = provincial;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public AddressEntity(String email) {
		super();
		this.email = email;
	}
	public AddressEntity(String email, String phone, String provincial, String address) {
		super();
		this.email = email;
		this.phone = phone;
		this.provincial = provincial;
		this.address = address;
	}


	
}
