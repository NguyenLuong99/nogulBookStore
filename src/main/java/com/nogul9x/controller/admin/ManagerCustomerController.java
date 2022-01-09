package com.nogul9x.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.EmployeeDAO;
import com.nogul9x.dao.RoleDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.dao.UserRoleDAO;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.service.ParamService;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class ManagerCustomerController {
	@Autowired
	SessionServiceImpl session;
	@Autowired
	UserDAO userDao;
	@Autowired
	RoleDAO roleDao;
	@Autowired
	UserRoleDAO userRoleDao;
	@Autowired
	EmployeeDAO employeeDao;
	@Autowired
	ParamService param;
	@RequestMapping("/admin/customerTable/list")
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

		Page<UserEntity> page = userDao.fillUserToTable("%"+findName+"%", pageable);
		model.addAttribute("userItem", page);
		
		return "admin/customerTable";
	}
	
//	@RequestMapping("/admin/customerTable/list/delete/{employeeId}")
//	public String delete(Model model, @PathVariable("employeeId") Long eid) {
//		List<UserRole> userRole = userRoleDao.findByUserId(eid);
//		for(UserRole u : userRole) {
//			userRoleDao.delete(u);
//		}
//		
//		EmployeeEntity employee = userDao.findEmployeeById(eid);
//		employeeDao.delete(employee);
//		
//		return "redirect:/admin/customerTable/list";
//	}
}
