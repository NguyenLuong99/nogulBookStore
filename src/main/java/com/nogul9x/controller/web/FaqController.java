package com.nogul9x.controller.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.FavoriteDAO;
import com.nogul9x.dao.PublisherDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.PublisherEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.model.BookDetail;
import com.nogul9x.model.LoginUser;
import com.nogul9x.model.ShowCategory;
import com.nogul9x.service.impl.SessionServiceImpl;

 

@Controller

public class FaqController {
	@Autowired
	PublisherDAO publisherDao;
	@Autowired
	BookCate bookCateDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	FavoriteDAO favoriteDao;
	@GetMapping("/faq")
	public String index(Model model, Principal principal) {
		UserEntity user = sessionService.get("user");
		if(user!=null) {
		int count = favoriteDao.countFavorite(user.getId());
		sessionService.set("countFavorite", count);
		}
		return "web/faq";
	}
	@GetMapping("/logout")
	public String logout() {
		return "web/faq";
	}

	@GetMapping("/successLogin")
	public String login(Model model, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		AccountEntity account = accountDao.findByEmail(loginedUser.getUsername());
		sessionService.set("account",account);
		UserEntity userEntity= userDao.findUserByAccountId(account.getId());
		sessionService.set("user",userEntity);
		String img ="https://scontent.fhan5-7.fna.fbcdn.net/v/t1.30497-1/143086968_2856368904622192_1959732218791162458_n.png?_nc_cat=1&ccb=1-5&_nc_sid=7206a8&_nc_ohc=3dulhYS2xWgAX98Yk3S&_nc_ht=scontent.fhan5-7.fna&oh=7e8465be1b0ffa6ac454ed4be41b7b5e&oe=61D93578";
		LoginUser user = new LoginUser(account.getFullname(),img);
		sessionService.set("userLogin",user);
		int count = favoriteDao.countFavorite(userEntity.getId());
		sessionService.set("countFavorite", count);

		return "web/faq";
	}
   
   	@ModelAttribute("publisher")
   	public List<PublisherEntity> manufacture(Model model) {
   		List<PublisherEntity> list = publisherDao.findAll();
   		return list;
   	}
	@ModelAttribute("bookDetail")
   	public List<BookDetail> books(Model model) {
   		List<BookDetail> list = bookDao.getBookDetail();
// 		System.out.println(list);
   		return list;
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
	@ModelAttribute("listViewBook")
   	public List<BookEntity> listViewBook(Model model) {
   		List<BookEntity> list = bookDao.fillViewsDESC();
   		List<BookEntity> viewList= new ArrayList<>();
   		int dem=0;
   		for (BookEntity i : list) {
			dem++;
			if(dem<6) {
				viewList.add(i);
			}
		}
// 		System.out.println(list);
   		return viewList;
   	}
	@ModelAttribute("listSaleBook")
   	public List<BookDetail> listSaleBook(Model model) {
		List<BookDetail> list = bookDao.getBookDetail();
   		List<BookDetail> viewList= new ArrayList<>();
   		int dem=0;
   		for (BookDetail i : list) {
   			if(i.getSale()>=25) {
   				dem++;
   				if(dem<6) {
   					viewList.add(i);
   				}
   			}
		
		}
// 		System.out.println(list);
   		return viewList;
   	}

}