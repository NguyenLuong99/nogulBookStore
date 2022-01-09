package com.nogul9x.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.nogul9x.service.impl.MailerServiceImpl;
@Controller
public class RegisterMailContoller {
	@Autowired
	MailerServiceImpl service;
	@PostMapping("/mailNotif")
	public String mailNotif(Model model, HttpServletRequest req) {
		service.queue(req.getParameter("email"), "Cảm ơn bạn đã đăng ký trang!", "Hãy thường xuyên check mail để nhận thông báo.");
		return "redirect:/faq";
	}
}
