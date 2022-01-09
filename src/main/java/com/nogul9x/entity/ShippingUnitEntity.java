package com.nogul9x.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="shippingUnit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingUnitEntity extends BaseEntity implements Serializable {
	private String name;
	private float price;
	private String location;
	@OneToOne(mappedBy = "shipping")
	private ShipmentEntity shipment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ShipmentEntity getShipment() {
		return shipment;
	}
	public void setShipment(ShipmentEntity shipment) {
		this.shipment = shipment;
	}
	
}
