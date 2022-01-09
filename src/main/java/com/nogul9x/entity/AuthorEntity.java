package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity  extends BaseEntity implements Serializable {
	private String name;
	private int numberOfbook;
	private String des;
	private String image;
	@OneToMany(mappedBy = "author")
	private List <BookEntity> books = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfbook() {
		return numberOfbook;
	}
	public void setNumberOfbook(int numberOfbook) {
		this.numberOfbook = numberOfbook;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public List<BookEntity> getBooks() {
		return books;
	}
	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
	public AuthorEntity(long id, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String name,
			int numberOfbook, String des ){
		super(id, createdBy, createdDate, modifiedBy, modifiedDate);
		this.name = name;
		this.numberOfbook = numberOfbook;
		this.des = des;
	}

	
	
}
