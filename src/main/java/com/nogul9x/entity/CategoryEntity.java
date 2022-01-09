package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends BaseEntity implements Serializable  {
	@Column(name="code")
	private String code;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy = "category")
	private List<BookCateEntity> bookcates = new ArrayList<>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BookCateEntity> getBookcates() {
		return bookcates;
	}
	public void setBookcates(List<BookCateEntity> bookcates) {
		this.bookcates = bookcates;
	}
	public CategoryEntity(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	
}
