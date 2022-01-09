package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nogul9x.entity.AddressEntity;
import com.nogul9x.entity.CustomerEntity;
import com.nogul9x.entity.EmployeeEntity;
import com.nogul9x.entity.FullNameEntity;
import com.nogul9x.entity.UserEntity;
@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long>{
	@Query("SELECT u FROM UserEntity as u WHERE u.account.id = ?1")
	UserEntity findUserByAccountId(Long id);
	@Query("SELECT u FROM UserEntity as u WHERE u.fbAccount.id = ?1")
	UserEntity findUserByFbAccountId(Long id);
	@Query("SELECT u FROM UserEntity as u WHERE u.ggAccount.id = ?1")
	UserEntity findUserByGGAccountId(Long id);
	@Query("Select u.address from UserEntity u where u.id=?1")
	AddressEntity findAddressById(Long id);
	@Query("Select u.fullName from UserEntity u where u.id=?1")
	FullNameEntity findFullNameById(Long id);
	@Query("Select c from CustomerEntity c")
	List <CustomerEntity> findAllCustomer();
	@Query("Select count(u) from UserEntity u")
	int countCustomer();
	@Query("Select count(e) from EmployeeEntity e")
	int countEmployee();
	@Query("Select e from EmployeeEntity e where e.id=?1")
	EmployeeEntity findEmployeeById(Long id);
	@Query("SELECT e FROM EmployeeEntity e where e.fullName.firstname LIKE ?1 or e.fullName.lastname LIKE ?1")
	Page<EmployeeEntity> fillEmployeeToTable(String fullname, Pageable pageable);
	@Query("SELECT u FROM UserEntity u where u.fullName.firstname LIKE ?1 or u.fullName.lastname LIKE ?1")
	Page<UserEntity> fillUserToTable(String fullname, Pageable pageable);
}
