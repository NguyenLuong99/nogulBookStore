package com.nogul9x.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.OrderDAO;
import com.nogul9x.model.StatisOrder;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class AdminStatisBookController {
	@Autowired
	SessionServiceImpl session;
	@Autowired
	OrderDAO orderDao;
	@RequestMapping("/admin/statisBook")
	public String index(Model model, @RequestParam("keyword") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName ;
		if(session.get("keyword") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(session.get("keyword"));
			System.out.println(findName);
		}		
		
		session.set("keyword", findName);
//		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);

		Page<StatisOrder> page = orderDao.fillStatisBookADayToTable(findName, pageable);
		model.addAttribute("statisDayItem", page);
		
		return "admin/statisBook";
	}
	@RequestMapping("/admin/statisBookMonth")
	public String indexMonth(Model model, @RequestParam("keyword") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName ;
		if(session.get("keyword") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(session.get("keyword"));
			System.out.println(findName);
		}		
		
		session.set("keyword", findName);
//		
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
		Page<StatisOrder> monthPage = orderDao.fillStatisBookADayToTable("%"+findName+"%", pageable);
		model.addAttribute("statisMonthItem", monthPage);

		
		return "admin/statisBookByMonth";
	}
	@RequestMapping("/admin/statisBookYear")
	public String indexYear(Model model, @RequestParam("keyword") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName ;
		if(session.get("keyword") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(session.get("keyword"));
			System.out.println(findName);
		}		
		
		session.set("keyword", findName);
//		
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
		Page<StatisOrder> yearPage = orderDao.fillStatisBookADayToTable("%"+findName+"%", pageable);
		model.addAttribute("statisYearItem", yearPage);
		
		return "admin/statisBookByYear";
	}
	@ModelAttribute("locationDay")
	public int location( Model model){
		int count=  0;
		return count;
	}
	@ModelAttribute("locationMonth")
	public int locationDay( Model model){
		int count=  0;
		return count;
	}
	@ModelAttribute("locationYear")
	public int locationYear( Model model){
		int count=  0;
		return count;
	}
	@ModelAttribute("totalDay")
	public int total( Model model){
		int count=  0;
		return count;
	}
	@ModelAttribute("totalMonth")
	public int totalMonth( Model model){
		int count=  0;
		return count;
	}
	@ModelAttribute("totalYear")
	public int totalYear( Model model){
		int count=  0;
		return count;
	}
}
