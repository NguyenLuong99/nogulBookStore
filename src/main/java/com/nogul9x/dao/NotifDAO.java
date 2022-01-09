package com.nogul9x.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.NotifEntity;

public interface NotifDAO extends JpaRepository<NotifEntity, Long>{
	@Query("SELECT n FROM NotifEntity n WHERE n.user.id = ?1 Order by n.dDate DESC")
	Page<NotifEntity> fillToTable(Long id, Pageable pageable);
	@Query("Select n from NotifEntity n where n.news.id=?1")
	NotifEntity findNotifByNewId(Long id);
}
