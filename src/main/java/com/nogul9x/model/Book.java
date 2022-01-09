package com.nogul9x.model;

import org.springframework.web.multipart.MultipartFile;

public class Book extends AbstractDTO<Book>{
	private String name;
	private String des;
	private float inPrice;
	private float price;
	private float salePrice;
	private MultipartFile imgBook;
	private int quality;
	private String pubDay;
	private String publisher;
	private String author;
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
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public MultipartFile getImgBook() {
		return imgBook;
	}
	public void setImgBook(MultipartFile imgBook) {
		this.imgBook = imgBook;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public float getInPrice() {
		return inPrice;
	}
	public void setInPrice(float inPrice) {
		this.inPrice = inPrice;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public String getPubDay() {
		return pubDay;
	}
	public void setPubDay(String pubDay) {
		this.pubDay = pubDay;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
}
