package com.nogul9x.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nogul9x.entity.CategoryEntity;

public interface CategoryDAO extends JpaRepository<CategoryEntity, Long>{
	@Query("SELECT c FROM CategoryEntity c WHERE c.name LIKE ?1")
	Page<CategoryEntity> fillToTable(String fullname, Pageable pageable);
}
