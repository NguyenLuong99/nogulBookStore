package com.nogul9x.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="bookcate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCateEntity extends BaseEntity implements Serializable {
	@ManyToOne
	@JoinColumn(name="book_Id")
	private BookEntity book;
	@ManyToOne
	@JoinColumn(name="category_Id")
	private CategoryEntity category;

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
}
