package com.nogul9x.model;

public class Shipment extends AbstractDTO<Shipment>{
	private String type;
	private String startOfDate;
	private String enOfDate;
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
	
}
