package com.nogul9x.controller.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.config.PaypalPaymentIntent;
import com.nogul9x.config.PaypalPaymentMethod;
import com.nogul9x.dao.AddressDAO;
import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.FullNameDAO;
import com.nogul9x.dao.NotifDAO;
import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PaymentDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AddressEntity;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.FullNameEntity;
import com.nogul9x.entity.NotifEntity;
import com.nogul9x.entity.OrderEntity;
import com.nogul9x.entity.PaymentEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.model.Address;
import com.nogul9x.model.FullName;
import com.nogul9x.model.Item;
import com.nogul9x.model.ShowCategory;
import com.nogul9x.service.PaypalService;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.service.impl.ShoppingCartServiceImpl;
import com.nogul9x.validator.AddressValidator;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;



@Controller

public class AddressController {
	@Autowired
	AddressValidator addressValidator;
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
	AddressDAO addressDao;
	@Autowired
	FullNameDAO fullNameDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	OrderDAO orderDao;
	@Autowired
	PaymentDAO paymentDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	BookCate bookCateDao;
	@Autowired
	NotifDAO notifDao;
	@Autowired
	ShoppingCartServiceImpl cart;
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private PaypalService paypalService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Address.class) {
			binder.setValidator(addressValidator);
		}
	}
	@GetMapping("/check-out")
	public String index(Model model) {
		UserEntity user = sessionService.get("user");
		AddressEntity addressEntity = userDao.findAddressById(user.getId());
		Address address = new Address();
		FullNameEntity fullNameEntity = userDao.findFullNameById(user.getId());
		FullName fullname =new FullName();
		model.addAttribute("address", addressEntity.getEmail());
		if (address != null) {
			address.setFirstname(fullNameEntity.getFirstname());
			address.setLastname(fullNameEntity.getLastname());
			address.setAddress(addressEntity.getAddress());
			address.setEmail(addressEntity.getEmail());
			address.setPhone(addressEntity.getPhone());
			address.setProvincial(addressEntity.getProvincial());
		}
		model.addAttribute("cart", cart);
		model.addAttribute("addressForm", address);
		return "web/check-out";
	}
	@PostMapping("/check-out")
	public String save(Model model, @ModelAttribute("addressForm") @Validated Address entity,
			BindingResult result) {
		if (result.hasErrors()) {
			return "web/check-out";
		} else {
			UserEntity user = sessionService.get("user");
			AddressEntity addressEntity = userDao.findAddressById(user.getId());
			Address address = new Address();
			FullNameEntity fullNameEntity = userDao.findFullNameById(user.getId());
			FullName fullname =new FullName();
			addressEntity.setAddress(entity.getAddress());
			addressEntity.setEmail(entity.getEmail());
			addressEntity.setPhone(entity.getPhone());
			addressEntity.setProvincial(entity.getProvincial());
			addressDao.save(addressEntity);
			
			fullNameEntity.setFirstname(entity.getFirstname());
			fullNameEntity.setLastname(entity.getLastname());
			fullNameDao.save(fullNameEntity);
			List<Item> list = new ArrayList<>(cart.getItems());
			float price = 0;
			for (Item i : list) {
				price = price + i.getPrice() * i.getQuality();
			}
			

			try {
				Payment payment = paypalService.createPayment(
						price, 
						"USD", 
						PaypalPaymentMethod.paypal, 
						PaypalPaymentIntent.sale,"payment description",
						"https://localhost:8443/pay/success", 
						"https://localhost:8443/pay/success");
				for(Links links : payment.getLinks()){
					if(links.getRel().equals("approval_url")){
						return "redirect:" + links.getHref();
					}
				}
			} catch (PayPalRESTException e) {
				log.error(e.getMessage());
			}
//			serviceMail.queue(entity.getEmail(), "Xác nhận đơn hàng!", "Code xác nhận của bạn là: " + code);
			return "web/check-out";
		}
	}
	@GetMapping("/pay/success")
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){

		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				UserEntity user = sessionService.get("user");
				int code;
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate = formatter.format(date);
				while (true) {
					code = (int) Math.floor(((Math.random() * 899999) + 100000));
					List<OrderEntity> list = orderDao.getOrderByName(String.valueOf(code));
					if (list.isEmpty()) {
						break;
					}
				}
				List<Item> listItem = new ArrayList<>(cart.getItems());
				for (Item i : listItem) {
					//System.out.println(i.getIdColor());
					BookEntity book = bookDao.findBookByLongId(i.getId());
					OrderEntity order = new OrderEntity(String.valueOf(code), strDate, false, true, i.getQuality(),user,book);
					float total= book.getSalePrice()*i.getQuality();
					orderDao.save(order);
					
					PaymentEntity payments = new PaymentEntity("Chuyen Khoan",total,strDate,order);
					paymentDao.save(payments);
				}
				String con= user.getFullName().getFirstname()+" "+user.getFullName().getLastname()+"đã thêm một đơn hàng !";
				NotifEntity notif = new NotifEntity(con,strDate,date,userDao.getById((long)3)); 
				notifDao.save(notif);
				cart.clear();
				sessionService.set("countProduct", cart.getCount());
				return "web/thankyou";
				
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}
	@ModelAttribute("total")
	public float tolal() {
		List<Item> list = new ArrayList<>(cart.getItems());
		float total = 0;
		for (Item i : list) {
			total = total + i.getPrice() * i.getQuality();
		}
		return total;
	}
	@ModelAttribute("bookcate")
   	public List<ShowCategory> bookcate(Model model) {
   		List<ShowCategory> list = bookCateDao.getSelectCategory();
// 		System.out.println(list);
   		return list;
   	}
	@ModelAttribute("listBookCate")
   	public List<BookCateEntity> listBookCate(Model model) {
   		List<BookCateEntity> list = bookCateDao.findListBookCate();
// 		System.out.println(list);
   		return list;
   	}
	@ModelAttribute("listBook")
   	public List<BookEntity> listBook(Model model) {
   		List<BookEntity> list = bookDao.findAll();
// 		System.out.println(list);
   		return list;
   	}
}
