package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.NewEntity;
import com.nogul9x.model.FeedBack;

public interface NewDAO extends JpaRepository<NewEntity, Long> {
	@Query("SELECT new FeedBack(n,n.user.imgUser,n.user.fullName.firstname,n.user.fullName.lastname) FROM NewEntity n WHERE n.book.id=?1")
	Page<FeedBack> fillToTable(Long id,Pageable pageable);
	@Query("SELECT new FeedBack(n,n.user.imgUser,n.user.fullName.firstname,n.user.fullName.lastname) FROM NewEntity n WHERE n.book.name LIKE ?1")
	Page<FeedBack> fillNameToTable(String name,Pageable pageable);
	@Query("select n from NewEntity n where n.book.id=?1")
	List<NewEntity> findListNewByBookId(Long id);
	@Query("Select count(n) from NewEntity n")
	int countNew();
}
