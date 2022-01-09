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
@Table(name="role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BaseEntity implements Serializable {
	@Column(name="code")
	private String code;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy = "role")
    private List<UserRole> use_role = new ArrayList<>();
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
	public List<UserRole> getUse_role() {
		return use_role;
	}
	public void setUse_role(List<UserRole> use_role) {
		this.use_role = use_role;
	}

	
}
