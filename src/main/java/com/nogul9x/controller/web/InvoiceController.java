package com.nogul9x.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PaymentDAO;
import com.nogul9x.entity.OrderEntity;
import com.nogul9x.entity.PaymentEntity;


@Controller
public class InvoiceController {
	@Autowired
	OrderDAO orderDao;
	@Autowired
	PaymentDAO paymentDao;
	
	@GetMapping("/shop/invoice/{name}")
	public String index(Model model, @PathVariable("name") String name) {
		
		return "web/invoice";
	}
	@ModelAttribute("order")
	public List<OrderEntity> order(@PathVariable("name") String name, Model model){
		List<OrderEntity> list = orderDao.getOrderByName(name);
		List<PaymentEntity> listPayment = new ArrayList<>();
	float total = 0;
		for(OrderEntity o: list) {
			PaymentEntity payments = paymentDao.findPaymentByOrderId(o.getId());
			listPayment.add(payments);
			total = total + payments.getTotalPrice();
		}
		model.addAttribute("listPayment", listPayment);
		model.addAttribute("total", total);
		model.addAttribute("address", list.get(0).getUser().getAddress());
		model.addAttribute("fullname", list.get(0).getUser().getFullName());
		return list;
	}
	
	@ModelAttribute("name")
	public String name(@PathVariable("name") String name) {
		return name;
	}
	
	@ModelAttribute("location")
	public int location() {
		return 0;
	}
}
