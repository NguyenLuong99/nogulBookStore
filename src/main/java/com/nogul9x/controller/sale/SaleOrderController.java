package com.nogul9x.controller.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PaymentDAO;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.OrderEntity;
import com.nogul9x.entity.PaymentEntity;
import com.nogul9x.model.Order;
import com.nogul9x.service.impl.SessionServiceImpl;


@Controller
public class SaleOrderController {
	@Autowired
	SessionServiceImpl sessionService;
	
	@Autowired
	OrderDAO orderDao;
	@Autowired
	PaymentDAO paymentDao;
	@Autowired
	BookDAO bookDao;
	
	@RequestMapping("/sale/order/wait")
	public String index(Model model, @RequestParam("keyword11") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		//User user = sessionService.get("userLogin");
		String findName;
		if(sessionService.get("keyword11") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(sessionService.get("keyword11"));
		}		
		
		sessionService.set("keyword11", findName);
		
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		
		Page<Order> list = paymentDao.fillTableWOrder("%" + findName + "%", pageable);
		model.addAttribute("orderWait", list);
		return "sale/orderWTable";
	}
	
	@GetMapping("/sale/orderDetail/{name}")
	public String detail(Model model, @PathVariable("name") String name) {
		List<OrderEntity> list = orderDao.getOrderByName(name);
		List<PaymentEntity> listPayment = new ArrayList<>();
			for(OrderEntity o: list) {
				PaymentEntity payments = paymentDao.findPaymentByOrderId(o.getId());
				listPayment.add(payments);
			}
		model.addAttribute("orderDetail", listPayment);
		model.addAttribute("address", list.get(0).getUser().getAddress());
		model.addAttribute("account", list.get(0).getUser().getAccount());
		model.addAttribute("fullname", list.get(0).getUser().getFullName());
		model.addAttribute("location", 0);
		return "sale/orderDetail";
	}
	
	@GetMapping("/sale/order/wait/send/{name}")
	public String send(Model model, @PathVariable("name") String name) {
		List<OrderEntity> list = orderDao.getOrderByName(name);
		for(OrderEntity o:list) {
			int quality= o.getBook().getQuality()-o.getQuality();
			BookEntity book = o.getBook();
			int oQuality= book.getoQuality();
			oQuality = oQuality + o.getQuality();
			book.setQuality(quality);
			book.setoQuality(oQuality);
			bookDao.save(book);
		}
		for(OrderEntity o: list) {
			o.setStatus(true);
			orderDao.save(o);
		}
		return "redirect:/sale/order/wait";
	}
	
	@RequestMapping("/sale/order/send")
	public String sending(Model model, @RequestParam("keyword12") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		//User user = sessionService.get("userLogin");
		String findName;
		if(sessionService.get("keyword12") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(sessionService.get("keyword12"));
		}		
		
		sessionService.set("keyword12", findName);
		
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		
		Page<Order> list = paymentDao.fillTableWOrder2("%" + findName + "%", pageable);
		model.addAttribute("orderSend", list);
		return "sale/orderSTable";
	}
}
