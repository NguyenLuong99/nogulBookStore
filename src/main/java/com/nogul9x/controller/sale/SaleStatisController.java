package com.nogul9x.controller.sale;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.FavoriteDAO;
import com.nogul9x.dao.OrderDAO;
import com.nogul9x.model.StatisFavorite;
import com.nogul9x.model.StatisOrder;
import com.nogul9x.service.impl.SessionServiceImpl;


@Controller
public class SaleStatisController {
	@Autowired
	SessionServiceImpl sessionService;
	
	@Autowired
	FavoriteDAO favoriteDao;
	
	@Autowired 
	OrderDAO orderDao;
	
	@GetMapping("/sale/statis/favorite")
	public String favorite(Model model, @RequestParam("keyword13") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName;
		if(sessionService.get("keyword13") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(sessionService.get("keyword13"));
		}		
		
		sessionService.set("keyword13", findName);
		
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		
		Page<StatisFavorite> list = favoriteDao.fillStatisToTable("%" + findName + "%", pageable);
		model.addAttribute("statisFavorite", list);
		model.addAttribute("location", 0);
		return "sale/statisFavorite";
	}
	
	@GetMapping("/sale/statis/order")
	public String order(Model model, @RequestParam("keyword14") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName;
		if(sessionService.get("keyword13") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(sessionService.get("keyword13"));
		}		
		
		sessionService.set("keyword13", findName);
		
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		
		Page<StatisOrder> list = orderDao.fillToTable("%" + findName + "%", pageable);
		model.addAttribute("statisOrder", list);
		model.addAttribute("location", 0);
		return "sale/statisOrder";
	}
}
