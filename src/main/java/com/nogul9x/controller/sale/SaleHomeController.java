package com.nogul9x.controller.sale;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.NotifDAO;
import com.nogul9x.entity.NotifEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class SaleHomeController {
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
	NotifDAO notifDao;
	@RequestMapping("/sale/home")
	public String index(Model model,@RequestParam("p") Optional<Integer> p) {
		UserEntity user = sessionService.get("user");
		Pageable pageable = PageRequest.of(p.orElse(0), 5);

		Page<NotifEntity> page = notifDao.fillToTable(user.getId(), pageable);
		model.addAttribute("userItem", page);
		sessionService.set("notifItem", page);
		return "sale/index";
	}
}
