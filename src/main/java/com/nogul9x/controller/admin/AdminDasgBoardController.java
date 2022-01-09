package com.nogul9x.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.NewDAO;
import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PaymentDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.CustomerEntity;
@Controller
public class AdminDasgBoardController {
	@Autowired
	UserDAO userDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	OrderDAO orderDao;
	@Autowired
	NewDAO newDao;
	@Autowired
	PaymentDAO paymentDao;
	@GetMapping("/admin/dashboard")
	public String index(Model model, Principal principal) {
		return "admin/dashboard";
	}
	@ModelAttribute("customer")
	public List<CustomerEntity> loadCategory( Model model){
		List<CustomerEntity> list = userDao.findAllCustomer(); 
		return list;
	}
	@ModelAttribute("numberCustomer")
	public int countCustomer( Model model){
		int count=  userDao.countCustomer();
		return count;
	}
	@ModelAttribute("numberEmployee")
	public int countEmployee( Model model){
		int count=  userDao.countEmployee();
		return count;
	}
	@ModelAttribute("numberView")
	public long countView( Model model){
		long count=  bookDao.countView();
		return count;
	}
	@ModelAttribute("numberBook")
	public int countBook( Model model){
		int count= bookDao.countBook();
		return count;
	}
	@ModelAttribute("numberOrder")
	public int countOrdered( Model model){
		int count=  orderDao.countOrder();
		return count;
	}
	@ModelAttribute("numberFeedBack")
	public int countFeedBack( Model model){
		int count=  newDao.countNew();
		return count;
	}
	@ModelAttribute("totalPrice")
	public long totalPrice( Model model){
		Long count=  paymentDao.findRevenueAll();
		return count;
	}
	@ModelAttribute("totalBookSaled")
	public long totalBookSaled( Model model){
		Long count=  paymentDao.findBookSaledAll();
		return count;
	}


}
