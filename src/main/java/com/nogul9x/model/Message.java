package com.nogul9x.model;

public class Message extends AbstractDTO<Message> {
	private String email;
	private String title;
	private String name;
	private String content;
	public Message(String email, String title, String name, String content) {
		super();
		this.email = email;
		this.title = title;
		this.name = name;
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
