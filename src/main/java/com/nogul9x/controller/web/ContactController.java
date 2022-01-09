package com.nogul9x.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nogul9x.dao.MessageDAO;
import com.nogul9x.entity.MessageEntity;
import com.nogul9x.model.Message;
import com.nogul9x.validator.MessageValidator;

@Controller
public class ContactController {
	@Autowired
	MessageValidator messageValidator;
	@Autowired
	MessageDAO messageDao;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Message.class) {
			binder.setValidator(messageValidator);
		}
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView faqPage() {
		ModelAndView mav = new ModelAndView("web/contact-us");
		return mav;
	}

	@PostMapping("/contact")
	public String senMessage(Model model, @ModelAttribute("Message") @Validated Message entity, BindingResult result) {
		if (result.hasErrors()) {
			return "web/contact-us";
		}else {
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			  Date today = new Date();
			  String strDate = sdf.format(today);
			  String content = entity.getEmail() + " ("+ entity.getName()+") send: "+entity.getContent();
			MessageEntity message = new MessageEntity(content,entity.getTitle(),strDate);
			messageDao.save(message);
		}
		return "web/contact-us";
	}

}
