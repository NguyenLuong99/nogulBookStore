package com.nogul9x.controller.admin;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminCalenderController {
	@GetMapping("/admin/calendar")
	public String index(Model model, Principal principal) {
		return "admin/calendar";
	}
}
