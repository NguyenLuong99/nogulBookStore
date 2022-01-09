package com.nogul9x.controller.sale;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nogul9x.dao.AuthorDAO;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.CategoryDAO;
import com.nogul9x.dao.FavoriteDAO;
import com.nogul9x.dao.NewDAO;
import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PublisherDAO;
import com.nogul9x.dao.UserDAO;

@Controller
public class SaleDashBoardController {
	@Autowired
	UserDAO userDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	OrderDAO orderDao;
	@Autowired
	AuthorDAO authorDao;
	@Autowired
	PublisherDAO publisherDao;
	@Autowired
	CategoryDAO categoryDao;
	@Autowired
	FavoriteDAO favoriteDao;
	@Autowired
	NewDAO newDao;
	@GetMapping("/sale/dashboard")
	public String indexSale(Model model, Principal principal) {
		return "sale/dashboard";
	}
	@ModelAttribute("numberAuthor")
	public long countCustomer( Model model){
		long count=  authorDao.count();
		return count;
	}
	@ModelAttribute("numberPublisher")
	public long countEmployee( Model model){
		long count=  publisherDao.count();
		return count;
	}
	@ModelAttribute("numberCategory")
	public long countCategory( Model model){
		long count=  categoryDao.count();
		return count;
	}
	@ModelAttribute("numberBook")
	public int countBook( Model model){
		int count= bookDao.countBook();
		return count;
	}
	@ModelAttribute("numberOrdered")
	public int countOrdered( Model model){
		int count=  orderDao.countOrdered();
		return count;
	}
	@ModelAttribute("numberOrder")
	public int countOrder( Model model){
		int count=  orderDao.countOrder();
		return count;
	}
	@ModelAttribute("numberFavorite")
	public long countFavorite( Model model){
		long count=  favoriteDao.count();
		return count;
	}
	@ModelAttribute("numberFeedBack")
	public int countFeedBack( Model model){
		int count=  newDao.countNew();
		return count;
	}

}
