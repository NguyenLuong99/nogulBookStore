package com.nogul9x.controller.admin;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.OrderDAO;
import com.nogul9x.dao.PaymentDAO;
import com.nogul9x.model.StatisOrder;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class AdminStatisController {
	@Autowired
	SessionServiceImpl session;
	@Autowired
	OrderDAO orderDao;
	@Autowired
	PaymentDAO paymentDao;
	@RequestMapping("/admin/statis")
	public String index(Model model, @RequestParam("month") Optional<String> requestMonth, @RequestParam("year") Optional<String> requestYear) {
		String year;
		String month;
		if(session.get("month") == null||session.get("year")==null ) {
			year = requestYear.orElse("2021");
			month=requestMonth.orElse("1");
			
		}
		else {
			year = requestYear.orElse(session.get("year"));
			month = requestMonth.orElse(session.get("month"));
			session.set("monthSearch", requestMonth.orElse("month"));
		}		
		session.set("year", year);	
		if(Integer.parseInt(month)<10) {
			month= "0"+month;
		}
		session.set("month", month);	
		int type=0;
		List<Float> revenue = new ArrayList<>();
		if(Integer.parseInt(month)==1||Integer.parseInt(month)==3||Integer.parseInt(month)==5||Integer.parseInt(month)==8
				||Integer.parseInt(month)==7||Integer.parseInt(month)==10||Integer.parseInt(month)==12) {
			for(int i=1;i<=31;i++) {
				float a1=0;
				revenue.add(a1);
			}
		}else if(Integer.parseInt(month)==2) {
			if(Integer.parseInt(year)%4!=0) {
				for(int i=1;i<=28;i++) {
					float a1=0;
					revenue.add(a1);
				}
				type=1;
				
			}else {
				for(int i=1;i<=29;i++) {
					float a1=0;
					revenue.add(a1);
				}
				type=2;
			}
			
		}else{
			for(int i=1;i<=30;i++) {
				float a1=0;
				revenue.add(a1);
			}
			type=3;
		}
		model.addAttribute("type", type);
		List<String> dayLabels = new ArrayList<>();
		dayLabels= paymentDao.getDayRevenue("%"+year+"-"+month+"%");
		model.addAttribute("dayLabels", dayLabels);
		List<Float> RevenueDay= new ArrayList<>();
		RevenueDay =paymentDao.getRevenue("%"+year+"-"+month+"%");
		model.addAttribute("revenueDay", RevenueDay);
		if(dayLabels!=null) {
			for(String day:dayLabels) {
				int d ;
				if(day.substring(8,9).equalsIgnoreCase("0")) {
					d= Integer.parseInt(day.substring(9,10));
				}else {
				d= Integer.parseInt(day.substring(8,10));}
				
				revenue.set(d-1, RevenueDay.get(dayLabels.indexOf(day))) ;
			}
		}
		model.addAttribute("revenue", revenue);
		return "admin/statis";
	}
	@GetMapping("/admin/statisMonth")
	public String indexMonth(Model model, @RequestParam("year") Optional<String> requestYear) {
		String year;
		if(session.get("year")==null ) {
			year = requestYear.orElse("2021");
		}
		else {
			year = requestYear.orElse(session.get("year"));
		}		
		session.set("year", year);
		List<Float> revenueMonth = new ArrayList<>();
		for(int i=1;i<=12;i++) {
			float a1=0;
			revenueMonth.add(a1);
		}
			for(int i=1;i<=12;i++) {
				if(i<10) {
					if(paymentDao.getRevenueMonth("%"+year+"-0"+String.valueOf(i)+"%")!=null) {
						revenueMonth.set(i-1,paymentDao.getRevenueMonth("%"+year+"-0"+String.valueOf(i)+"%"));
					}
					
				}else {
					if(paymentDao.getRevenueMonth("%"+year+"-"+String.valueOf(i)+"%")!=null) {
						revenueMonth.set(i-1,paymentDao.getRevenueMonth("%"+year+"-"+String.valueOf(i)+"%"));
					}
				}
			}
		model.addAttribute("revenueMonth", revenueMonth);
		return "admin/statisByMonth";
	}
	@GetMapping("/admin/statisYear")
	public String indexYear(Model model, Principal principal) {
		String year1="2021";
		String year2="2022";
		session.set("year1", year1);
		session.set("year2", year2);
		List<Float> revenueMonth1 = new ArrayList<>();
		List<Float> revenueMonth2 = new ArrayList<>();
		for(int i=1;i<=12;i++) {
			float a1=0;
			revenueMonth1.add(a1);
			revenueMonth2.add(a1);
		}
			for(int i=1;i<=12;i++) {
				if(i<10) {
					if(paymentDao.getRevenueMonth("%"+year1+"-0"+String.valueOf(i)+"%")!=null) {
						revenueMonth1.set(i-1,paymentDao.getRevenueMonth("%"+year1+"-0"+String.valueOf(i)+"%"));
					}
					
				}else {
					if(paymentDao.getRevenueMonth("%"+year1+"-"+String.valueOf(i)+"%")!=null) {
						revenueMonth1.set(i-1,paymentDao.getRevenueMonth("%"+year1+"-"+String.valueOf(i)+"%"));
					}
				}
			}
		model.addAttribute("revenueMonth1", revenueMonth1);
		for(int i=1;i<=12;i++) {
			if(i<10) {
				if(paymentDao.getRevenueMonth("%"+year2+"-0"+String.valueOf(i)+"%")!=null) {
					revenueMonth2.set(i-1,paymentDao.getRevenueMonth("%"+year2+"-0"+String.valueOf(i)+"%"));
				}
				
			}else {
				if(paymentDao.getRevenueMonth("%"+year2+"-"+String.valueOf(i)+"%")!=null) {
					revenueMonth2.set(i-1,paymentDao.getRevenueMonth("%"+year2+"-"+String.valueOf(i)+"%"));
				}
			}
		}
		model.addAttribute("revenueMonth2", revenueMonth2);
		return "admin/statisByYear";
	}
}
