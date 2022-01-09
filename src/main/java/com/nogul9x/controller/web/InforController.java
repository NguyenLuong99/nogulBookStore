package com.nogul9x.controller.web;

import java.security.Principal;

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

import com.nogul9x.dao.AddressDAO;
import com.nogul9x.dao.FullNameDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AddressEntity;
import com.nogul9x.entity.FullNameEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.model.Address;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.AddressValidator;


@Controller
public class InforController {
	@Autowired
	AddressValidator addressValidator;
	
	@Autowired
	UserDAO userDao;
	@Autowired
	AddressDAO addressDao;
	@Autowired
	FullNameDAO fullnameDao;
	
	@Autowired
	SessionServiceImpl sessionService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		//Object target2 = binder2.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Address.class) {
			binder.setValidator(addressValidator);
		}
	}
	
	@GetMapping("/my-address")
	public String index(Model model) {
		UserEntity user= sessionService.get("user");
		AddressEntity address = userDao.findAddressById(user.getId());
		FullNameEntity fullname = userDao.findFullNameById(user.getId());
		Address entity = new Address();
		if (address != null) {
			entity.setFirstname(fullname.getFirstname());
			entity.setLastname(fullname.getLastname());
			entity.setAddress(address.getAddress());
			entity.setEmail(address.getEmail());
			entity.setPhone(address.getPhone());
			entity.setProvincial(address.getProvincial());
			entity.setPhone(address.getPhone());
		}
		
		model.addAttribute("address", entity);
		return "web/my-address";
	}
	
	@PostMapping("/update/my-address")
	public String save(Model model, @ModelAttribute("addressForm") @Validated Address entity, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("ok");
			return "web/my-address";
		} else {
			UserEntity user= sessionService.get("user");
			AddressEntity address = userDao.findAddressById(user.getId());
			FullNameEntity fullname = userDao.findFullNameById(user.getId());
			if (address == null) {
				address = new AddressEntity(entity.getEmail(),
				entity.getPhone(), entity.getProvincial(), entity.getAddress());
				addressDao.save(address);
			} else {
				address.setAddress(entity.getAddress());
				address.setEmail(entity.getEmail());
				address.setPhone(entity.getPhone());
				address.setProvincial(entity.getProvincial());
				addressDao.save(address);
			}
			if (fullname == null) {
				fullname = new FullNameEntity(entity.getFirstname(),entity.getLastname());
				fullnameDao.save(fullname);
			} else {
				fullname.setFirstname(entity.getFirstname());
				fullname.setLastname(entity.getLastname());
				fullnameDao.save(fullname);
			}
			return "redirect:/my-address";
		}	
	}
}
