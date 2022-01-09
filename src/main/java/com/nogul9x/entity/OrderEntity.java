package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends BaseEntity implements Serializable {
	private String name;
	private String date;
	private boolean status;
	private boolean method;
	private int quality;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookEntity book;
	@OneToMany(mappedBy = "order")
	private List<PaymentEntity> payment=new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="shipment_id")
	private ShipmentEntity shipment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isMethod() {
		return method;
	}
	public void setMethod(boolean method) {
		this.method = method;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public BookEntity getBook() {
		return book;
	}
	public void setBook(BookEntity book) {
		this.book = book;
	}
	public List<PaymentEntity> getPayment() {
		return payment;
	}
	public void setPayment(List<PaymentEntity> payment) {
		this.payment = payment;
	}
	public ShipmentEntity getShipment() {
		return shipment;
	}
	public void setShipment(ShipmentEntity shipment) {
		this.shipment = shipment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public OrderEntity(String name, String date, boolean status, boolean method, int quality, UserEntity user,
			BookEntity book) {
		super();
		this.name = name;
		this.date = date;
		this.status = status;
		this.method = method;
		this.quality = quality;
		this.user = user;
		this.book = book;

	}
	
	
	
}
