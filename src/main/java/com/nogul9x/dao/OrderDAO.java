package com.nogul9x.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nogul9x.entity.OrderEntity;
import com.nogul9x.model.StatisOrder;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
	@Query("SELECT o FROM OrderEntity o WHERE o.name LIKE ?1")
	List<OrderEntity> getOrderByName(String name);
	@Query("SELECT new com.nogul9x.model.StatisOrder(o.book, count(o),o.date) FROM OrderEntity o WHERE o.book.name Like ?1 GROUP BY o.book ")
	Page<StatisOrder> fillToTable(String name, Pageable pageable);
	@Query("select count(o) from OrderEntity o where o.status= 1")
	int countOrdered();
	@Query("select count(o) from OrderEntity o where o.status= 0")
	int countOrder();
	@Query("SELECT new com.nogul9x.model.StatisOrder(o.book, sum(o.quality),o.date) FROM OrderEntity o where o.date Like ?1 and o.status = 1  group by o.book,o.date")
	Page<StatisOrder> fillStatisBookADayToTable(String name, Pageable pageable);
	
}
