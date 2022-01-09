package com.nogul9x.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.AddressDAO;
import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.model.ChangePassword;
import com.nogul9x.model.ShowCategory;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.ChangePasswordValidator;



@Controller
public class UserProfileController {
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
	ChangePasswordValidator changepassValidator;
	@Autowired
	BookCate bookCateDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	AddressDAO dao;
	
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		//Object target2 = binder2.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == ChangePassword.class) {
			binder.setValidator(changepassValidator);
		}
	}
	@GetMapping("/my-profile")
	public String index(Model model) {
		ChangePassword entity = new ChangePassword();
		AccountEntity  account= sessionService.get("account");
		entity.setEmail(account.getEmail());
		entity.setFullname(account.getFullname());
		model.addAttribute("account", entity);
		return "web/taikhoan";
	}
	@PostMapping("/update/my-profile")
	public String save(Model model, @ModelAttribute("user") @Validated ChangePassword entity, BindingResult result) {		
		if (result.hasErrors()) {
			System.out.println("ijj");
			return "web/taikhoan";
		} else {
			AccountEntity account= sessionService.get("account");
			account.setFullname(entity.getFullname());
			if(!entity.getNewPassword().isEmpty()) {
				String password = passwordEncoder.encode(entity.getNewPassword());
				account.setPassword(password);
			}
			accountDao.save(account);
			return "redirect:/my-profile";
		}
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