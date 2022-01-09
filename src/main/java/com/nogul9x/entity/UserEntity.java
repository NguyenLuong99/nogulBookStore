package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="user")
@DiscriminatorValue("")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {

	@Column(name="status")
	private Integer status;
	@Column(name="imgUser")
	private String imgUser;
	private String phone;
	@OneToMany(mappedBy = "user")
	private List<UserRole> user_role=new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private AddressEntity address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fullName_id")
	private FullNameEntity fullName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id")
	private AccountEntity account;
	@ManyToOne
	@JoinColumn(name="ggAccount_id")
	private GGAccountEntity ggAccount;
	@ManyToOne
	@JoinColumn(name="fbAccount_id")
	private FbAccountEntity fbAccount;
	@OneToMany(mappedBy = "user")
	private List<NewEntity> news= new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<OrderEntity> orders = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<NotifEntity> notifs= new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<MessageEntity> messages= new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<InBookEntity> inBooks= new ArrayList<>();
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<UserRole> getUser_role() {
		return user_role;
	}
	public void setUser_role(List<UserRole> user_role) {
		this.user_role = user_role;
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
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public FullNameEntity getFullName() {
		return fullName;
	}
	public void setFullName(FullNameEntity fullName) {
		this.fullName = fullName;
	}
	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	public AccountEntity getGgAccount() {
		return ggAccount;
	}
	public void setGgAccount(GGAccountEntity account) {
		this.ggAccount = account;
	}
	public AccountEntity getFbAccount() {
		return fbAccount;
	}
	public void setAccount(FbAccountEntity account) {
		this.fbAccount = account;
	}
	public List<OrderEntity> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	public UserEntity( AddressEntity address, FullNameEntity fullName, AccountEntity account) {
		super();
		this.address = address;
		this.fullName = fullName;
		this.account = account;
	}
	public UserEntity( AddressEntity address, FullNameEntity fullName, GGAccountEntity account) {
		super();
		this.address = address;
		this.fullName = fullName;
		this.ggAccount = account;
	}
	public UserEntity( AddressEntity address, FullNameEntity fullName, FbAccountEntity account) {
		super();
		this.address = address;
		this.fullName = fullName;
		this.fbAccount = account;
	}
	
	
}
