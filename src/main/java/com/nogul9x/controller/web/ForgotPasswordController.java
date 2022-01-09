package com.nogul9x.controller.web;

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

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.model.ForgotPassword;
import com.nogul9x.service.MailerService;
import com.nogul9x.validator.ForgotPasswordValidator;

@Controller
public class ForgotPasswordController {
	@Autowired
	ForgotPasswordValidator forgotPassValidator;
	
	@Autowired
	MailerService service;
	
	@Autowired
	AccountDAO dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == ForgotPassword.class) {
			binder.setValidator(forgotPassValidator);
		}
	}
	
	@GetMapping("/forgot-password")
	public String index(Model model) {
		ForgotPassword entity = new ForgotPassword();
		model.addAttribute("forgotPassword", entity);
		return "web/forgot-password";
	}
	
	@PostMapping("/forgot-password")
	public String send(@ModelAttribute("forgotPassword") @Validated ForgotPassword entity, BindingResult result, Model model) {
		model.addAttribute("check", false);
		if(!result.hasErrors()) {
			AccountEntity account = dao.findByEmail(entity.getEmail());
			service.queue(entity.getEmail(), "Làm mới mật khẩu!", "Vui lòng click vào link này: "+ "https://localhost:8443/reset-password/?code="+account.getPassword()+"&email="+account.getEmail() +" để reset mật khẩu.");

			return "web/success-password";
		}
		else {
			
		}
	//	return "redirect:/login";
		return "web/forgot-password";
	}
	
	
}
