package com.nogul9x.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="notif")
@Data

@NoArgsConstructor
public class NotifEntity extends BaseEntity {
	private String content;
	private String date;
	private Date dDate; 
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user ;
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookEntity book;
	@ManyToOne
	@JoinColumn(name="new_id")
	private NewEntity news;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
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
	public NewEntity getNews() {
		return news;
	}
	public void setNews(NewEntity news) {
		this.news = news;
	}

	public NotifEntity(String content, String date, Date dDate, UserEntity user, BookEntity book, NewEntity news) {
		super();
		this.content = content;
		this.date = date;
		this.dDate = dDate;
		this.user = user;
		this.book = book;
		this.news = news;
	}
	public NotifEntity(String content, String date, Date dDate, UserEntity user) {
		super();
		this.content = content;
		this.date = date;
		this.dDate = dDate;
		this.user = user;
	}


}
