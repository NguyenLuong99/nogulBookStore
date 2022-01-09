package com.nogul9x.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.model.FillProCate;


public interface FillCategoryDAO extends JpaRepository<FillProCate, Long>{
	@Query("SELECT new FillProCate(p.id, p.book.name, p.category.name) FROM BookCateEntity p WHERE p.category.name LIKE ?1")
	Page<FillProCate> fillToTable(String name, Pageable pageable);
}
