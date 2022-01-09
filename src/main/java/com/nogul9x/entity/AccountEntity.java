package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account")
@DiscriminatorValue("1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private String email;
	private String password;
	private String fullname;
	private String type;
	
	@OneToOne(mappedBy = "account")
	private UserEntity user;
	@OneToMany(mappedBy = "account")
	private List<PaymentEntity> payments = new ArrayList<>();

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public AccountEntity(String email, String password, String fullname,String type) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.type=type;
	}
	public List<PaymentEntity> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentEntity> payments) {
		this.payments = payments;
	}

	
	
}
