package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nogul9x.entity.RoleEntity;
@Repository
public interface RoleDAO extends JpaRepository<RoleEntity, Long> {
	@Query("SELECT u.role.name FROM UserRole as u WHERE u.user.id = :uid")
	List<String> getRoleNames(@Param("uid") Long id);
}
