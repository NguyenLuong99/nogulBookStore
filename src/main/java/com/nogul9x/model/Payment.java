package com.nogul9x.model;

public class Payment extends AbstractDTO<Payment> {
	private String type;
	private float totalPrice;
	private String detail;
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
	
}
