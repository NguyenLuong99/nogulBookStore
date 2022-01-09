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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="fbAccount")
@DiscriminatorValue("3")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FbAccountEntity extends AccountEntity implements Serializable  {
	public FbAccountEntity(String email, String password, String fullname,String type) {
		super(email, password, fullname,type);
		// TODO Auto-generated constructor stub
	}

	private String img;
	@OneToOne(mappedBy = "fbAccount")
	private UserEntity user;
	@OneToMany(mappedBy = "fbAccount")
	private List<PaymentEntity> payments = new ArrayList<>();
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public FbAccountEntity(String email, String password, String fullname,String type,String img) {
		super(email, password, fullname,type);
		this.img = img;
	}
	

	
}
