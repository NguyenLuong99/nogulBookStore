package com.nogul9x.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity extends BaseEntity implements Serializable {
	private String type;
	private float totalPrice;
	private String detail;
	@ManyToOne
	@JoinColumn(name="orders_id")
	private OrderEntity order;
	@ManyToOne
	@JoinColumn(name="account_id")
	private AccountEntity account;
	@ManyToOne
	@JoinColumn(name="ggAccount_id")
	private GGAccountEntity ggAccount;
	@ManyToOne
	@JoinColumn(name="fbAccount_id")
	private FbAccountEntity fbAccount;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	public PaymentEntity(String type, float totalPrice, String detail, OrderEntity order) {
		super();
		this.type = type;
		this.totalPrice = totalPrice;
		this.detail = detail;
		this.order = order;
	}

	
}
