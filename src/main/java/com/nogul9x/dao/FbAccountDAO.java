package com.nogul9x.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.FbAccountEntity;

public interface FbAccountDAO extends JpaRepository<FbAccountEntity, Long>{
	@Query("Select f from FbAccountEntity as f where f.fullname=?1 and f.type='3'")
	FbAccountEntity findByFullName(String name);

}
