package com.nogul9x.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nogul9x.entity.AddressEntity;

public interface AddressDAO extends JpaRepository<AddressEntity, Long> {
	
}
