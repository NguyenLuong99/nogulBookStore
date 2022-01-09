package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookEntity extends BaseEntity implements Serializable {
	private String name;
	private String des;
	private float inPrice;
	private float price;
	private float salePrice;
	private String imgBook;
	private int quality;
	private int oQuality;
	private int views=0;
	@ManyToOne
	@JoinColumn(name="author_id")
	private AuthorEntity author;
	@ManyToOne
	@JoinColumn(name="publisher_id")
	private PublisherEntity publisher;
	@OneToMany(mappedBy="book")
	private List<NewEntity> news =new ArrayList<>();
	@OneToMany(mappedBy = "book")
	private List<OrderEntity> orders =new ArrayList<>();
	@OneToMany(mappedBy = "book")
	private List<BookCateEntity> bookcates= new ArrayList<>();
	@OneToMany(mappedBy = "book")
	private List<InBookEntity> inBook= new ArrayList<>();
	@OneToMany(mappedBy = "book")
	private List<NotifEntity> notif= new ArrayList<>();
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
	public String getImgBook() {
		return imgBook;
	}
	public void setImgBook(String imgBook) {
		this.imgBook = imgBook;
	}


	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public AuthorEntity getAuthor() {
		return author;
	}
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	public PublisherEntity getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherEntity publisher) {
		this.publisher = publisher;
	}
	public List<NewEntity> getNews() {
		return news;
	}
	public void setNews(List<NewEntity> news) {
		this.news = news;
	}
	public List<OrderEntity> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	public List<BookCateEntity> getBookcates() {
		return bookcates;
	}
	public void setBookcates(List<BookCateEntity> bookcates) {
		this.bookcates = bookcates;
	}
	public BookEntity(long id, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String name,
			String des, float inPrice, float price, float salePrice, String imgBook, int quality,
			AuthorEntity author, PublisherEntity publisher
			) {
		super(id, createdBy, createdDate, modifiedBy, modifiedDate);
		this.name = name;
		this.des = des;
		this.inPrice = inPrice;
		this.price = price;
		this.salePrice = salePrice;
		this.imgBook = imgBook;
		this.quality = quality;
		this.author = author;
		this.publisher = publisher;
	}
	public int getoQuality() {
		return oQuality;
	}
	public void setoQuality(int oQuality) {
		this.oQuality = oQuality;
	}
	
	
	
}
