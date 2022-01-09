package com.nogul9x.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.FavoriteDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.FavoriteEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.model.Favorite;
import com.nogul9x.service.impl.SessionServiceImpl;

@Controller
public class FavoriteController {
	@Autowired
	FavoriteDAO favoriteDao;

	@Autowired
	UserDAO userDao;

	@Autowired
	BookDAO productDao;

	@Autowired
	SessionServiceImpl sessionService;

	@RequestMapping("/shop/favorite/{id}")
	public String index(Model model, @PathVariable("id") long id) {
		UserEntity user = sessionService.get("user");
		BookEntity product = productDao.getById(id);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(date);
		FavoriteEntity entity = new FavoriteEntity(strDate, user, product);
		favoriteDao.save(entity);

		int count = favoriteDao.countFavorite(user.getId());
		sessionService.set("countFavorite", count);
		return "redirect:/detail-book/" + id;
	}
	@RequestMapping("/shop/unFavorite/{id}")
	public String unFavorite(Model model, @PathVariable("id") long id) {
		UserEntity user = sessionService.get("user");
		FavoriteEntity entity = favoriteDao.getFavorite(user.getId(), id);
		favoriteDao.delete(entity);
		int count = favoriteDao.countFavorite(user.getId());
		sessionService.set("countFavorite", count);
		return "redirect:/detail-book/" + id;
	}
	
	@GetMapping("/my-favorites")
	public String favorite(Model model, @RequestParam("p") Optional<Integer> p) {
		UserEntity user = sessionService.get("user");
		Pageable pageable = PageRequest.of(p.orElse(0), 5);

		Page<FavoriteEntity> page = favoriteDao.fillToTable(user.getId(), pageable);
		model.addAttribute("favorite", page);
		model.addAttribute("location", 0);
		int count = favoriteDao.countFavorite(user.getId());
		sessionService.set("countFavorite", count);
		return "web/my-favorite";
	}
	
	@GetMapping("/shop/favorite/delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {		
		FavoriteEntity entity = favoriteDao.getById(id);
		favoriteDao.delete(entity);
		return "redirect:/my-favorites";
	
	}
}
