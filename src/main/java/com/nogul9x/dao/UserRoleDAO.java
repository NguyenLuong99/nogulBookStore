package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long>{
	@Query("Select u from UserRole u where u.user.id=?1")
	List<UserRole> findByUserId(Long id);
}
