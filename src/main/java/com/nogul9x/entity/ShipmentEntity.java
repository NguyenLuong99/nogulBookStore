package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="shipment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentEntity extends BaseEntity implements Serializable  {
	private String type;
	private String startOfDate;
	private String enOfDate;
	@OneToMany(mappedBy = "shipment")
	private List<OrderEntity> order= new ArrayList<>();
	@OneToOne
	@JoinColumn(name="shippingUnit_id",referencedColumnName = "id")
	private ShippingUnitEntity shipping;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartOfDate() {
		return startOfDate;
	}
	public void setStartOfDate(String startOfDate) {
		this.startOfDate = startOfDate;
	}
	public String getEnOfDate() {
		return enOfDate;
	}
	public void setEnOfDate(String enOfDate) {
		this.enOfDate = enOfDate;
	}
	public List<OrderEntity> getOrder() {
		return order;
	}
	public void setOrder(List<OrderEntity> order) {
		this.order = order;
	}
	public ShippingUnitEntity getShipping() {
		return shipping;
	}
	public void setShipping(ShippingUnitEntity shipping) {
		this.shipping = shipping;
	}
}
