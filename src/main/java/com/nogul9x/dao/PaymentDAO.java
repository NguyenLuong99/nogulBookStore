package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.PaymentEntity;
import com.nogul9x.model.Order;

public interface PaymentDAO extends JpaRepository<PaymentEntity, Long>{
	@Query("Select p from PaymentEntity p where p.order.id=?1")
	PaymentEntity findPaymentByOrderId(Long id);
	@Query("SELECT new com.nogul9x.model.Order(p.order.name,p.order.status,sum(p.totalPrice),p.order.date) FROM PaymentEntity p WHERE p.order.user.id = ?1 GROUP BY p.order.name,p.order.status, p.order.date")
	List<Order> getOrderModel(Long id);
	@Query("SELECT new com.nogul9x.model.Order(p.order.name,p.order.status,sum(p.totalPrice),p.order.date) FROM PaymentEntity p  WHERE p.order.status = 0 AND p.order.name LIKE ?1 GROUP BY p.order.name, p.order.date, p.order.status ORDER BY p.order.date ASC")
	Page<Order> fillTableWOrder(String name, Pageable pageable);
	@Query("SELECT new com.nogul9x.model.Order(p.order.name,p.order.status,sum(p.totalPrice),p.order.date) FROM PaymentEntity p WHERE p.detail Like ?1 GROUP BY p.order.name,p.order.status, p.order.date")
	List<Order> findOrder(String date);
	@Query("SELECT new com.nogul9x.model.Order(p.order.name,p.order.status,sum(p.totalPrice),p.order.date) FROM PaymentEntity p  WHERE p.order.status = 1 AND p.order.name LIKE ?1 GROUP BY p.order.name, p.order.date, p.order.status ORDER BY p.order.date ASC")
	Page<Order> fillTableWOrder2(String name, Pageable pageable);
	@Query("Select sum(p.totalPrice) from PaymentEntity p ")
	Long findRevenueAll();
	@Query("Select sum(p.order.quality) from PaymentEntity p ")
	Long findBookSaledAll();
	@Query("Select sum(p.totalPrice) from PaymentEntity p where p.order.status= 1 and p.order.date Like ?1 group by p.order.date, p.order.status")
	List<Float>  getRevenue(String date);
	@Query("Select p.order.date from PaymentEntity p where p.order.status= 1 and p.order.date Like ?1 group by p.order.date, p.order.status")
	List<String>  getDayRevenue(String date);
	@Query("Select sum(p.totalPrice) from PaymentEntity p where p.order.status= 1 and p.order.date Like ?1")
	Float  getRevenueMonth(String date);
}
