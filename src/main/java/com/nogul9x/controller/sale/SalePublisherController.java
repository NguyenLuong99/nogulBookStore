package com.nogul9x.controller.sale;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.PublisherDAO;
import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.PublisherEntity;
import com.nogul9x.model.Author;
import com.nogul9x.model.Publisher;
import com.nogul9x.service.ParamService;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.PublisherValidator;

@Controller
public class SalePublisherController {
	@Autowired
	PublisherDAO publisherDao;
	@Autowired
	PublisherValidator publisherValidator;
	@Autowired
	SessionServiceImpl session;
	@Autowired
	ParamService param;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Publisher.class) {
			binder.setValidator(publisherValidator);
		}
	}
	@RequestMapping("/sale/publisherTable/list")
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

		Page<PublisherEntity> page = publisherDao.fillToTable("%"+findName+"%", pageable);
		model.addAttribute("publisherItem", page);
		
		return "sale/publisherTable";
	}
	@GetMapping("/sale/publisherForm/form")
	public String index(Model model) {
		session.set("nameImage2", "");
		Publisher publisher = new Publisher();
		model.addAttribute("publisherForm", publisher);
		return "sale/publisherForm";
	}
	@GetMapping("/sale/publisherTable/list/load/{id}")
	public String load(Model model, @PathVariable("id") long id) {
		PublisherEntity publisherEntity = publisherDao.getById(id);
		Publisher publisher = new Publisher();
		publisher.setName(publisherEntity.getName());
		publisher.setDes(publisherEntity.getDes());
		publisher.setLocation(publisherEntity.getLocation());
		model.addAttribute("edit2", true);
		model.addAttribute("publisherForm", publisher);
		session.set("nameImage2", publisherEntity.getCreatedBy());
		session.set("id2", publisherEntity.getId());
		return "sale/publisherForm";
	}
	@RequestMapping("/sale/publisherTable/list/delete/{publisherId}")
	public String delete(Model model, @PathVariable("publisherId") long eid) {
		PublisherEntity publisher = publisherDao.getById(eid);
		publisherDao.delete(publisher);
		
		return "redirect:/sale/publisherTable/list";
	}
	@RequestMapping("/sale/publisherForm/form/edit/{id}")
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute("publisherForm") Publisher entity,
			BindingResult result) {
		model.addAttribute("edit2", true);
		if (entity.getName().isEmpty()) {
			result.rejectValue("name", "NotBlank.manuForm.name");
		}
		if(entity.getDes().isEmpty()) {
			result.rejectValue("des", "NotBlank.manuForm.information");
		}
		if(!result.hasErrors()) {
			PublisherEntity publisherEntity = publisherDao.getById(id);
			publisherEntity.setName(entity.getName());
			publisherEntity.setDes(entity.getDes());
			publisherEntity.setLocation(entity.getLocation());
			if (!entity.getImage().isEmpty()) {				
				publisherEntity.setCreatedBy(param.save(entity.getImage()));			
			}
			publisherDao.save(publisherEntity);
			model.addAttribute("edit2", false);
			session.set("nameImage2", "");
			return "redirect:/sale/publisherTable/list";
		}
		
		return "sale/authorForm";
	}
	@PostMapping("/sale/publisherForm/form")
	public String save(Model model, @ModelAttribute("publisherForm") @Validated Publisher entity,
			BindingResult result) {
		if (result.hasErrors()) {
			return "sale/publisherForm";
		}

		else {			
			int code;
			code= (int) Math.floor(((Math.random() * 99) + 100));;
			PublisherEntity publisherEntity= new PublisherEntity(code, param.save(entity.getImage()),null,"",null,entity.getName(),entity.getLocation(),entity.getDes());
			publisherDao.save(publisherEntity);
		}
		return "redirect:/sale/publisherTable/list";
	}
	
	@RequestMapping("/sale/publisherForm/refresh")
	public String refresh(Model model) {
		return "redirect:/sale/publisherForm/form";
	}
}
