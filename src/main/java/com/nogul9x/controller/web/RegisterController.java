package com.nogul9x.controller.web;

import javax.servlet.http.HttpServletRequest;

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

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.AddressDAO;
import com.nogul9x.dao.FullNameDAO;
import com.nogul9x.dao.RoleDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.dao.UserRoleDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.entity.AddressEntity;
import com.nogul9x.entity.FullNameEntity;
import com.nogul9x.entity.RoleEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.entity.UserRole;
import com.nogul9x.model.RegisterUser;
import com.nogul9x.service.impl.MailerServiceImpl;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.RegisterFormValidator;

@Controller
public class RegisterController {
	private static final Object UserRo = null;

	@Autowired
	private UserDAO userDao;
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private AddressDAO addressDao;
	@Autowired
	private FullNameDAO fullNameDAO;
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private UserRoleDAO userRoleDao;

	@Autowired
	MailerServiceImpl service;

	@Autowired
	RegisterFormValidator userRegisterValidator;

	@Autowired
	SessionServiceImpl sessionService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == RegisterUser.class) {
			binder.setValidator(userRegisterValidator);
		}
	}

	@GetMapping("/register")
	public String index(Model model) {
		RegisterUser entity = new RegisterUser();
		System.out.println("this is code: " + sessionService.get("code"));
		model.addAttribute("userRegister", entity);
		return "web/register";
	}

	@PostMapping("/register/{check}")
	public String save(Model model, @ModelAttribute("userRegister") @Validated RegisterUser entity,
			BindingResult result, @PathVariable("check") String check) {
		// System.out.println(check);
		
		if (check.equals("mailSender")) {
			
			 System.out.println(entity);
			int code = (int) Math.floor(((Math.random() * 899999) + 100000));
			System.out.println(code);
			sessionService.set("code", code);
			service.queue(entity.getEmail(), "Xác nhận Email!", "Code xác nhận của bạn là: " + code);
		}
		if (result.hasErrors()) {
			System.out.println(entity.getFirstName());
			return "web/register";
		} else {

			if (sessionService.get("code") == null) {
				result.rejectValue("code", "NotDuplicate.userRegister.code");
			} else {
				if (entity.getCode().equals(sessionService.get("code").toString()) == false) {
					//System.out.println("your code is " + entity.getCode());
					//System.out.println("this is code: " + sessionService.get("code"));
					result.rejectValue("code", "NotDuplicate.userRegister.code");
				} else {
					System.out.println("đúng");
					String password = passwordEncoder.encode(entity.getPassword());
					AccountEntity account = new AccountEntity(entity.getEmail(),password,entity.getFirstName()+" "+entity.getLastName(),"1");
					AddressEntity address = new AddressEntity(entity.getEmail());
					FullNameEntity fullname = new FullNameEntity(entity.getFirstName(),entity.getLastName());
					UserEntity user = new UserEntity(address,fullname,account);
					userDao.save(user);
					RoleEntity role = roleDao.getOne((long)2);
					UserRole userRole = new UserRole(user, role);
					userRoleDao.save(userRole);
					return "redirect:/login";
				}
			}
		}
			
		return "web/register";
	}
	
	
}
