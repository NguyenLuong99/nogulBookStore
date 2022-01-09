package com.nogul9x.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.FavoriteEntity;
import com.nogul9x.model.StatisFavorite;



public interface FavoriteDAO extends JpaRepository<FavoriteEntity, Long>{
	@Query("select count(b) from FavoriteEntity b where b.user.id = ?1")
	int countFavorite(Long id);
	
	@Query("SELECT f FROM FavoriteEntity f WHERE f.user.id = ?1 AND f.book.id = ?2")
	FavoriteEntity getFavorite(Long id, Long id2);
	
	@Query("SELECT f FROM FavoriteEntity f WHERE f.user.id= ?1")
	Page<FavoriteEntity> fillToTable(Long id, Pageable pageable);
	
	@Query("SELECT new StatisFavorite(f.book, count(f)) FROM FavoriteEntity f WHERE f.book.name Like ?1 GROUP BY f.book	 ")
	Page<StatisFavorite> fillStatisToTable(String name, Pageable pageable);
}
