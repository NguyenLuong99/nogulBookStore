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

import com.nogul9x.dao.AuthorDAO;
import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.model.Author;
import com.nogul9x.service.ParamService;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.AuthorValidator;


@Controller
public class AuthorController {
	@Autowired
	SessionServiceImpl session;
	@Autowired
	AuthorDAO authorDao;
	@Autowired
	AuthorValidator authorValidator;
	@Autowired
	ParamService param;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Author.class) {
			binder.setValidator(authorValidator);
		}
	}
	@RequestMapping("/sale/authorTable/list")
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

		Page<AuthorEntity> page = authorDao.fillToTable("%"+findName+"%", pageable);
		model.addAttribute("userItem", page);
		
		return "sale/authorTable";
	}
	@GetMapping("/sale/authorTable/form")
	public String index(Model model) {
		session.set("nameImage2", "");
		Author author = new Author();
		model.addAttribute("authorForm", author);
		return "sale/authorForm";
	}
	@GetMapping("/sale/authorTable/list/load/{id}")
	public String load(Model model, @PathVariable("id") long id) {
		AuthorEntity authorEntity = authorDao.getById(id);
		Author author = new Author();
		author.setName(authorEntity.getName());
		author.setDes(authorEntity.getDes());
		author.setNumberOfbook(authorEntity.getNumberOfbook());
		model.addAttribute("edit2", true);
		model.addAttribute("authorForm", author);
		session.set("nameImage2", authorEntity.getCreatedBy());
		session.set("id2", authorEntity.getId());
		return "sale/authorForm";
	}
	@RequestMapping("/sale/authorTable/list/delete/{authorId}")
	public String delete(Model model, @PathVariable("authorId") long eid) {
		AuthorEntity author = authorDao.getById(eid);
		authorDao.delete(author);
		
		return "redirect:/sale/authorTable/list";
	}
	@RequestMapping("/sale/authorForm/form/edit/{id}")
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute("authorForm") Author entity,
			BindingResult result) {
		model.addAttribute("edit2", true);
		if (entity.getName().isEmpty()) {
			result.rejectValue("name", "NotBlank.manuForm.name");
		}
		if(entity.getDes().isEmpty()) {
			result.rejectValue("des", "NotBlank.manuForm.information");
		}
		if(!result.hasErrors()) {
			AuthorEntity authorEntity = authorDao.getById(id);
			authorEntity.setName(entity.getName());
			authorEntity.setDes(entity.getDes());
			authorEntity.setNumberOfbook(entity.getNumberOfbook());
			if (!entity.getImage().isEmpty()) {				
				authorEntity.setCreatedBy(param.save(entity.getImage()));			
			}
			authorDao.save(authorEntity);
			model.addAttribute("edit2", false);
			session.set("nameImage2", "");
			return "redirect:/sale/authorTable/list";
		}
		
		return "sale/authorForm";
	}
	@PostMapping("/sale/authorForm/form")
	public String save(Model model, @ModelAttribute("authorForm") @Validated Author entity,
			BindingResult result) {
		if (result.hasErrors()) {
			return "sale/authorForm";
		}

		else {			
			int code;
			code= (int) Math.floor(((Math.random() * 99) + 100));;
			AuthorEntity authorEntity= new AuthorEntity(code, param.save(entity.getImage()),null,"",null,entity.getName(),entity.getNumberOfbook(),entity.getDes());
			authorDao.save(authorEntity);
		}
		return "redirect:/sale/authorForm/list";
	}
	
	@RequestMapping("/sale/authorForm/refresh")
	public String refresh(Model model) {
		return "redirect:/sale/authorTable/form";
	}
}
