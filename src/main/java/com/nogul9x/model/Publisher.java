package com.nogul9x.model;

import org.springframework.web.multipart.MultipartFile;

public class Publisher extends AbstractDTO<Publisher>{
	private String name;
	private String location;
	private String des;
	private MultipartFile image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	

}
