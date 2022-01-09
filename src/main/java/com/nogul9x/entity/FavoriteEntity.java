package com.nogul9x.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="favorites")
@Data

@NoArgsConstructor
public class FavoriteEntity extends BaseEntity {
	private String date;
	@ManyToOne
	@JoinColumn(name="user_Id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="book_Id")
	private BookEntity book;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public FavoriteEntity(String date, UserEntity user, BookEntity book) {
		super();
		this.date = date;
		this.user = user;
		this.book = book;
	}
	
	
}
