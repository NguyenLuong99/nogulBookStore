package com.nogul9x.controller.sale;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.NewDAO;
import com.nogul9x.entity.NewEntity;
import com.nogul9x.model.FeedBack;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class SaleFeedBackController {
	@Autowired
	SessionServiceImpl session;
	@Autowired
	NewDAO newsDao;
	@RequestMapping("/sale/feedBackTable/list")
	public String index(Model model, @RequestParam("keyword") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName;
		if(session.get("keyword") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(session.get("keyword"));
		}		
		
		session.set("keyword", findName);
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);

		Page<FeedBack> page = newsDao.fillNameToTable("%"+findName+"%", pageable);
		model.addAttribute("userItem", page);
		
		return "sale/FeedBackTable";
	}
	@RequestMapping("/sale/feedBackTable/list/delete/{feedBackId}")
	public String delete(Model model, @PathVariable("feedBackId") long eid) {
		NewEntity news = newsDao.getById(eid);
		newsDao.delete(news);
		
		return "redirect:/sale/feedBackTable/list";
	}
}
