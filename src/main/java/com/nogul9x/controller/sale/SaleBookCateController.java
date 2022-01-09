package com.nogul9x.controller.sale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.CategoryDAO;
import com.nogul9x.dao.FillCategoryDAO;
import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.CategoryEntity;
import com.nogul9x.entity.PublisherEntity;
import com.nogul9x.model.FillProCate;
import com.nogul9x.model.ProductCateModel;
import com.nogul9x.service.impl.SessionServiceImpl;



@Controller
public class SaleBookCateController {
	@Autowired
	BookCate bookcateDao;

	@Autowired
	CategoryDAO categoryDao;

	@Autowired
	BookDAO bookDao;

	@Autowired
	FillCategoryDAO procateDao;

	@Autowired
	SessionServiceImpl	 session;

	@RequestMapping("/sale/bookCateForm/form")
	public String index(Model model, @RequestParam("keyword5") Optional<String> name,
			@RequestParam("p") Optional<Integer> p2) {
		// Load select category
		Map<Long, String> map = new HashMap<Long, String>();
		List<CategoryEntity> list = categoryDao.findAll();
		for (CategoryEntity c : list) {
			map.put(c.getId(), c.getName());
		}
		ProductCateModel entity = new ProductCateModel();
		model.addAttribute("productcate", entity);
		model.addAttribute("category", map);

		// Load select product
		List<BookEntity> list2 = bookcateDao.findListBookByCateId(list.get(0).getId());
		// List<Product> list = productDao.findProduct();
		Map<Long, String> map2 = new HashMap<Long, String>();
		for (BookEntity p : list2) {
			map2.put(p.getId(), p.getName());
		}
		model.addAttribute("product", map2);

		// find by name
		String findName;
		if (session.get("keyword5") == null) {
			findName = name.orElse("");
		} else {
			findName = name.orElse(session.get("keyword5"));
		}

		session.set("keyword5", findName);

		Pageable pageable = PageRequest.of(p2.orElse(0), 5);

		Page<FillProCate> page = procateDao.fillToTable("%" + findName + "%", pageable);
		model.addAttribute("procateItem", page);

		return "sale/productcateForm";
	}

//	@RequestMapping("/sale/productCateForm/change/{id}")
//	public String change(Model model, @PathVariable("id") String id,
//			@ModelAttribute("productcate") ProductCateModel entity, @RequestParam("keyword5") Optional<String> name,
//			@RequestParam("p") Optional<Integer> p2) {
//		System.out.println("đúng");
//		System.out.println(id);
//
//		// System.out.println(entity.getCateId());
//
//		Map<Long, String> map2 = new HashMap<Long, String>();
//		List<CategoryEntity> list2 = categoryDao.findAll();
//		for (CategoryEntity c : list2) {
//			map2.put(c.getId(), c.getName());
//		}
//		model.addAttribute("category", map2);
//
//		List<BookEntity> list = productDao.findProduct(Integer.parseInt(id));
//		// List<Product> list = productDao.findProduct();
//		Map<Integer, String> map = new HashMap<Integer, String>();
//		for (Product p : list) {
//			map.put(p.getId(), p.getName());
//		}
//		// model.addAttribute("product", map);
//		model.addAttribute("product", map);
//
//		entity.setCateId(id);
//
//		// find by name
//		String findName;
//		if (session.get("keyword5") == null) {
//			findName = name.orElse("");
//		} else {
//			findName = name.orElse(session.get("keyword5"));
//		}
//
//		session.set("keyword5", findName);
//
//		Pageable pageable = PageRequest.of(p2.orElse(0), 5);
//
//		Page<FillProCate> page = procateDao.fillToTable("%" + findName + "%", pageable);
//		model.addAttribute("procateItem", page);
//
//		return "manager/productcateForm";
//	}
//
	@PostMapping("/sale/productCateForm/save")
	public String save(Model model, @ModelAttribute("productcate") ProductCateModel entity) {
		BookEntity product = bookDao.getById(Long.parseLong(entity.getProductId()));
		CategoryEntity category = categoryDao.getById(Long.parseLong(entity.getCateId()));
		BookCateEntity productcate = new BookCateEntity(product, category);
		bookcateDao.save(productcate);
		return "redirect:/sale/bookCateForm/form";
	}
	
	@RequestMapping("/sale/productCateForm/form/delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {
		BookCateEntity entity = bookcateDao.findBookCateById(id);
		bookcateDao.delete(entity);
		return "redirect:/sale/bookCateForm/form";
	}
	
	@ModelAttribute("bookList")
	public Map<Long, String> Book() {
		Map<Long, String> map = new HashMap();
		List<BookEntity> list = bookDao.findAll();
		for (BookEntity m : list) {
			map.put(m.getId(), m.getName());
		}
		return map;
	}
	@ModelAttribute("categoryList")
	public Map<Long, String> publisher() {
		Map<Long, String> map = new HashMap();
		List<CategoryEntity> list = categoryDao.findAll();
		for (CategoryEntity m : list) {
			map.put(m.getId(), m.getName());
		}
		return map;
	}
}
