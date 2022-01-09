package com.nogul9x.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ggAcount")
@DiscriminatorValue("2")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GGAccountEntity extends AccountEntity implements Serializable {
	public GGAccountEntity(String email, String password, String fullname,String type) {
		super(email, password, fullname,type);
		// TODO Auto-generated constructor stub
	}
	private String img;
	private String locate;
	@OneToOne(mappedBy = "ggAccount")
	private UserEntity user;
	@OneToMany(mappedBy = "ggAccount")
	private List<PaymentEntity> payments = new ArrayList<>();
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public GGAccountEntity(String email, String password, String fullname,String type, String img, String locate) {
		super(email, password, fullname,type);
		this.img = img;
		this.locate = locate;
	}


	
}
