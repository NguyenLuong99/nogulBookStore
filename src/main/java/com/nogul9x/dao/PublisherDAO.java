package com.nogul9x.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.PublisherEntity;

public interface PublisherDAO extends JpaRepository<PublisherEntity, Long>{

	@Query("SELECT p FROM PublisherEntity p WHERE p.name LIKE ?1")
	Page<PublisherEntity> fillToTable(String fullname, Pageable pageable);

}
