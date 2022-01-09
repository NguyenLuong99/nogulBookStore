package com.nogul9x.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.AuthorEntity;


public interface AuthorDAO extends JpaRepository<AuthorEntity, Long>{
	@Query("SELECT a FROM AuthorEntity a WHERE a.name LIKE ?1")
	Page<AuthorEntity> fillToTable(String fullname, Pageable pageable);
}
