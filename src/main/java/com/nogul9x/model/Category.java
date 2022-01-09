package com.nogul9x.model;

import org.springframework.web.multipart.MultipartFile;

public class Category extends AbstractDTO<Category> {
	private String name;
	private MultipartFile image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}


}
