package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="new")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewEntity extends BaseEntity implements Serializable {
	@Column(name="title")
	private String title;
	@Column(name="thumbnail")
	private String thumbnail;
	@Column(name="shortdescription")
	private String shortDescription;
	@Column(name="content")
	private String content;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookEntity book;
	@OneToMany(mappedBy = "news")
	private List<NotifEntity> notifs= new ArrayList<>();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BookEntity getBook() {
		return book;
	}
	public void setBook(BookEntity book) {
		this.book = book;
	}
	public NewEntity(String thumbnail, String content, UserEntity user, BookEntity book) {
		super();
		this.thumbnail = thumbnail;
		this.content = content;
		this.user = user;
		this.book = book;
	}
	
}
