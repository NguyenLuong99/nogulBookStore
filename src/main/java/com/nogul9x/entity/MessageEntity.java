package com.nogul9x.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mess")
public class MessageEntity extends BaseEntity{
	private String content;
	private String title;
	private String date;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
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
	public void setTitle(String title) {
		this.title = title;
	}
	public MessageEntity(String content, String title, String date, UserEntity user) {
		super();
		this.content = content;
		this.title = title;
		this.date = date;
		this.user = user;
	}
	public MessageEntity(String content, String title, String date) {
		super();
		this.content = content;
		this.title = title;
		this.date = date;
	}
	
	
}
