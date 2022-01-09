package com.nogul9x.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.BaseEntity;
import com.nogul9x.entity.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class ShowCategory {
	@Id
	Serializable group;
	Serializable book;
	Long count;
	public Serializable getGroup() {
		return group;
	}
	public void setGroup(Serializable group) {
		this.group = group;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public ShowCategory(Serializable group, Serializable book, Long count) {
		super();
		this.group = group;
		this.book = book;
		this.count = count;
	}

	
	
}
