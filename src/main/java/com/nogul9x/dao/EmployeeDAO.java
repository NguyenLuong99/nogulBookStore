package com.nogul9x.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nogul9x.entity.EmployeeEntity;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Long> {

}
