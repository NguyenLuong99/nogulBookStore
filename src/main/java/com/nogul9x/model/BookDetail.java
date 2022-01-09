package com.nogul9x.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter

@Entity
public class BookDetail {
	@Id
	Serializable group;
	private String publisher;
	private String author;
	private float price;
	private float salePrice;
	private float sale;
	private float esale;
	public BookDetail(Serializable group, String publisher, String author,float price, float salePrice) {
		super();
		this.group = group;
		this.publisher = publisher;
		this.author = author;
		this.esale= (int)(price-salePrice);
		this.sale= Math.round(this.esale/price*100*10)/10 ;
	}
	
}
