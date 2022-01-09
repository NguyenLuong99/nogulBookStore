package com.nogul9x.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nogul9x.entity.AccountEntity;
@Repository
public interface AccountDAO extends JpaRepository<AccountEntity, Long>{
	@Query("SELECT a FROM AccountEntity as a WHERE a.email = ?1 and a.type='1'")
	AccountEntity findByEmail(String email);

}
