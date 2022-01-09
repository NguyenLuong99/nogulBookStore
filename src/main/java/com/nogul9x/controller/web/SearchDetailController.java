package com.nogul9x.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.AuthorDAO;
import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.CategoryDAO;
import com.nogul9x.dao.PublisherDAO;
import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.CategoryEntity;
import com.nogul9x.entity.PublisherEntity;
import com.nogul9x.model.ShowCategory;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class SearchDetailController {
	@Autowired
	SessionServiceImpl session;
	@Autowired
	AuthorDAO authorDao;
	@Autowired
	BookDAO bookDao;
	@Autowired
	PublisherDAO publisherDao;
	@Autowired
	CategoryDAO categoryDao;
	@Autowired
	BookCate bookCateDao;
	@RequestMapping("/authorTable/list")
	public String author(Model model, @RequestParam("keyword") Optional<String> name, @RequestParam("p") Optional<Integer> p) {
		String findName;
		if(session.get("keyword") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(session.get("keyword"));
		}		
		
		session.set("keyword", findName);
		
		Pageable pageable = PageRequest.of(p.orElse(0), 4);

		Page<AuthorEntity> page = authorDao.fillToTable("%"+findName+"%", pageable);
		model.addAttribute("authorItem", page);
		Page<BookEntity> pageBook = bookDao.fillBookToTable("%"+findName+"%", pageable);
		model.addAttribute("bookItem", pageBook);
		Page<PublisherEntity> pagePublisher = publisherDao.fillToTable("%"+findName+"%", pageable);
		model.addAttribute("publisherItem", pagePublisher);
		Page<CategoryEntity> pageCate = categoryDao.fillToTable("%"+findName+"%", pageable);
		model.addAttribute("categoryItem", pageCate);
		
		return "web/searchPage";
	}
	@RequestMapping("/detail-author/{id}")
	public String authorDetail(@PathVariable("id") Long id, Model model, @RequestParam("p") Optional<Integer> p) {
		AuthorEntity author = authorDao.getById(id);
		model.addAttribute("author", author);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);

		Page<BookEntity> pageBook = bookDao.fillBookToTableByAuthorId(id, pageable);
		model.addAttribute("bookItem", pageBook);

		return "web/DetailAuthor";
	}
	@RequestMapping("/detail-publisher/{id}")
	public String publisherDetail(@PathVariable("id") Long id, Model model, @RequestParam("p") Optional<Integer> p) {
		PublisherEntity publisher = publisherDao.getById(id);
		model.addAttribute("publisher", publisher);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);

		Page<BookEntity> pageBook = bookDao.fillBookToTableByPublisherId(id, pageable);
		model.addAttribute("bookItem", pageBook);

		return "web/DetailPublisher";
	}
	@RequestMapping("/detail-category/{id}")
	public String categoryDetail(@PathVariable("id") Long id, Model model, @RequestParam("p") Optional<Integer> p) {
		CategoryEntity category = categoryDao.getById(id);
		model.addAttribute("category", category);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);

		Page<BookEntity> pageBook = bookDao.fillBookToTableByCategoryId(id, pageable);
		model.addAttribute("bookItem", pageBook);

		return "web/DetailCategory";
	}
	@ModelAttribute("bookcate")
   	public List<ShowCategory> bookcate(Model model) {
   		List<ShowCategory> list = bookCateDao.getSelectCategory();
// 		System.out.println(list);
   		return list;
   	}
	@ModelAttribute("listBookCate")
   	public List<BookCateEntity> listBookCate(Model model) {
   		List<BookCateEntity> list = bookCateDao.findListBookCate();
// 		System.out.println(list);
   		return list;
   	}
	@ModelAttribute("listBook")
   	public List<BookEntity> listBook(Model model) {
   		List<BookEntity> list = bookDao.findAll();
// 		System.out.println(list);
   		return list;
   	}
}
