package com.nogul9x.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PaymentDAO;
import com.nogul9x.entity.OrderEntity;
import com.nogul9x.entity.PaymentEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.model.Order;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class MyOdrerController {
	@Autowired
	SessionServiceImpl sessionService;
	
	@Autowired
	OrderDAO orderDao;	
	@Autowired
	PaymentDAO paymentDao;	
	@GetMapping("/my-order")
	public String index(Model model) {
		UserEntity user = sessionService.get("user");
		List<Order> list = paymentDao.getOrderModel(user.getId());
		model.addAttribute("location", 0);
		model.addAttribute("order", list);
		return "web/my-order";
	}
	
	@GetMapping("/my-order/delete/{name}")
	public String delete(Model model, @PathVariable("name") String name) {
		List<OrderEntity> list = orderDao.getOrderByName(name);
		for(OrderEntity o: list) {
			PaymentEntity pay = paymentDao.findPaymentByOrderId(o.getId());
			paymentDao.delete(pay);
			orderDao.delete(o);
		}
		return "redirect:/my-order";
	}
}
