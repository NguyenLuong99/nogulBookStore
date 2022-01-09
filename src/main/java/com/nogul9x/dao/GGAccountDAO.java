package com.nogul9x.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.AccountEntity;
import com.nogul9x.entity.GGAccountEntity;

public interface GGAccountDAO extends JpaRepository<GGAccountEntity, Long> {
	@Query("SELECT a FROM GGAccountEntity as a WHERE a.email = ?1 and a.type='2'")
	GGAccountEntity findByEmail(String email);
}
