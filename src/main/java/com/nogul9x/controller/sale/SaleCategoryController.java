package com.nogul9x.controller.sale;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

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

import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.CategoryDAO;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.CategoryEntity;
import com.nogul9x.model.Category;
import com.nogul9x.service.ParamService;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.CategoryValidator;



@Controller
public class SaleCategoryController {
	@Autowired
	CategoryValidator categoryValidator;

	@Autowired
	CategoryDAO categoryDao;

	@Autowired
	ServletContext app;

	@Autowired
	SessionServiceImpl session;
	@Autowired
	BookCate bookcateDao;
	@Autowired
	ParamService param;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Category.class) {
			binder.setValidator(categoryValidator);
		}
	}

	@GetMapping("/sale/categoryForm/form")
	public String index(Model model) {
		session.set("nameImage", "");
		Category entity = new Category();
		model.addAttribute("categoryForm", entity);
		return "sale/categoryForm";
	}

	@RequestMapping("/sale/categoryTable/list")
	public String index(Model model, @RequestParam("keyword3") Optional<String> name,
			@RequestParam("p") Optional<Integer> p) {
		String findName;
		if (session.get("keyword3") == null) {
			findName = name.orElse("");
		} else {
			findName = name.orElse(session.get("keyword3"));
		}

		session.set("keyword3", findName);

		Pageable pageable = PageRequest.of(p.orElse(0), 5);

		Page<CategoryEntity> page = categoryDao.fillToTable("%" + findName + "%", pageable);
		model.addAttribute("userItem", page);

		return "sale/categoryTable";
	}

	@RequestMapping("/sale/categoryTable/list/delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {
		List <BookCateEntity> bookcates = bookcateDao.findListBookCateByCateId(id);
		for(BookCateEntity b : bookcates) {
			bookcateDao.delete(b);
		}
		CategoryEntity entity = categoryDao.getById(id);
		categoryDao.delete(entity);
		return "redirect:/sale/categoryTable/list";
	}

	@PostMapping("/sale/categoryForm/form")
	public String save(Model model, @ModelAttribute("categoryForm") @Validated Category entity,
			BindingResult result) {
		if (result.hasErrors()) {
			return "sale/categoryForm";
		}

		else {			
			CategoryEntity category = new CategoryEntity( param.save(entity.getImage()),entity.getName());
			categoryDao.save(category);
		}
		return "redirect:/sale/categoryTable/list";
	}
	
	@GetMapping("/sale/categoryForm/list/load/{id}")
	public String load(Model model, @PathVariable("id") long id) {
		CategoryEntity category = categoryDao.getById(id);
		Category entity = new Category();
		entity.setName(category.getName());
		model.addAttribute("edit", true);
		model.addAttribute("categoryForm", entity);
		session.set("nameImage", category.getCode());
		session.set("id", category.getId());
		return "sale/categoryForm";
	}

	@RequestMapping("/sale/categoryForm/form/edit/{id}")
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute("categoryForm") Category entity,
			BindingResult result) {
		model.addAttribute("edit", true);
		if (entity.getName().isEmpty()) {
			result.rejectValue("name", "NotBlank.categoryForm.name");
		} else {
			CategoryEntity category = categoryDao.getById(id);
			category.setName(entity.getName());
			if (!entity.getImage().isEmpty()) {				
				category.setCode(param.save(entity.getImage()));			
			}
			categoryDao.save(category);
			model.addAttribute("edit", false);
			session.set("nameImage", "");
			return "redirect:/sale/categoryTable/list";
		}
		
		return "sale/categoryForm";
	}
}
