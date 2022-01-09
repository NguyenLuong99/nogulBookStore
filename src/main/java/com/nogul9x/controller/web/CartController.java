package com.nogul9x.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.model.Item;
import com.nogul9x.model.ShowCategory;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.service.impl.ShoppingCartServiceImpl;
@Controller
public class CartController {
	@Autowired
	ShoppingCartServiceImpl cart;
	@Autowired
	BookCate bookCateDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	SessionServiceImpl sessionService;
	@GetMapping("/cart")
	public String index(Model model) {
		model.addAttribute("cart", cart);
		return "web/cart";
	}
	@RequestMapping("/cart/update/{id}")
	public String update(@PathVariable("id") Long id, @RequestParam("quality") Integer qty) {
		cart.update(id, qty);
		return "redirect:/cart";
	}
	
	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		cart.remove(id);	
		sessionService.set("countProduct", cart.getCount());
		return "redirect:/cart";
	}
	
	@ModelAttribute("total")
	public Float tolal() {
		List<Item> list = new ArrayList<>(cart.getItems());
		float total = 0;
		for(Item i: list) {
			total = (total + i.getPrice() * i.getQuality());
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
