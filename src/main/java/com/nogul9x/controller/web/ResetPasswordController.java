package com.nogul9x.controller.web;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.model.ResetPassword;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.ResetPasswordValidator;


@Controller
public class ResetPasswordController {
	@Autowired
	ResetPasswordValidator resetPassValidator;
	@Autowired
	SessionServiceImpl session;
	@Autowired
	AccountDAO dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == ResetPassword.class) {
			binder.setValidator(resetPassValidator);
		}
	}

	@GetMapping("/reset-password")
	public String index(Model model) {
		ResetPassword entity = new ResetPassword();
		model.addAttribute("resetPassword", entity);
		return "web/ResetPassword";
	}
	@GetMapping("/reset-password/?{code}&{email}")
	public String reset(@PathVariable("code") String code,@PathVariable("id") String email,Model model) {
		ResetPassword entity = new ResetPassword();
		model.addAttribute("resetPassword", entity);
		session.set("email", email);
		System.out.println(email);
		return "web/ResetPassword";
	}
	@PostMapping("/reset-password")
	public String save(Model model, @RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "email", required = true) String email,
			@ModelAttribute("resetPassword") @Validated ResetPassword entity, BindingResult result) {
		
		if(result.hasErrors()) {
			return "web/ResetPassword";
		}
		
		else {
			System.out.println(email+"ok");
			AccountEntity account = dao.findByEmail(email);
			System.out.println(account);
			if(account == null) {
				return "redirect:/404page";
			}
			else {
				//System.out.println(code);
				//System.out.println(user.getPassword());
				if(code.equals(account.getPassword())) {
					account.setPassword(passwordEncoder.encode(entity.getPassword()));
					dao.save(account);
					return "web/success-reset";
				}
				else {
					return "redirect:/404page";
				}
			}
		}
		
		//return "user/success-reset";
	}

}
