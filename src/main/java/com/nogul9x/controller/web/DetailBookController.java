package com.nogul9x.controller.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.FavoriteDAO;
import com.nogul9x.dao.NewDAO;
import com.nogul9x.dao.NotifDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.CategoryEntity;
import com.nogul9x.entity.FavoriteEntity;
import com.nogul9x.entity.NewEntity;
import com.nogul9x.entity.NotifEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.model.BookDetail;
import com.nogul9x.model.FeedBack;
import com.nogul9x.model.Item;
import com.nogul9x.service.impl.HistoryBookServiceImpl;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.service.impl.ShoppingCartServiceImpl;



@Controller
public class DetailBookController {
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
	BookDAO bookDao;
	@Autowired
	BookCate bookCateDao;
	@Autowired
	NewDAO newDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	ShoppingCartServiceImpl cart;
	@Autowired
	FavoriteDAO favoriteDao;
	@Autowired
	HistoryBookServiceImpl historyBook;
	@Autowired
	NotifDAO notifDao;
	List<BookEntity> books= new ArrayList<>();
	 @RequestMapping(value = "/detail-book", method = RequestMethod.GET)
     public ModelAndView faqPage() {
            ModelAndView mav = new ModelAndView("web/detail-book");
            return mav;
     }

		@RequestMapping("/detail-book/{id}")
		public String index(@PathVariable("id") Long id, Model model, @RequestParam("p") Optional<Integer> p) {
			sessionService.set("cateId", id);
			BookEntity book = bookDao.findBookByLongId(id);
			int views = book.getViews()+1;
			book.setViews(views);
			bookDao.save(book);
			BookEntity product = bookDao.findBookByLongId(id);	
			
			Item entity = new Item();
			entity.setId(id);			
//			if(color!=null) {			
			entity.setImage(product.getImgBook());
			entity.setName(product.getName());
			entity.setPrice(product.getSalePrice());	
			historyBook.add(id, entity);
			model.addAttribute("historyBook", historyBook);
			List<BookEntity> books = new ArrayList<>();
			books = bookDao.fillBookByAuthorId(book.getAuthor().getId());
			model.addAttribute("authorBook", books);
			List<NewEntity> listNew= newDao.findListNewByBookId(id);
			int dem=1;
			for(NewEntity n:listNew) {
				dem++;
			}
			model.addAttribute("countFeedBack", dem);
			Pageable pageable = PageRequest.of(p.orElse(0), 5);

			Page<FeedBack> page = newDao.fillToTable(id, pageable);
			model.addAttribute("userItem", page);
			/*
			 * DetailModel entity = new DetailModel(); model.addAttribute("detail", entity);
			 */
			
//			List<ProductSize> list = productsizeDao.getSizeProduct(id);
//			List<LoadInfo> list2 = productcolorDao.getLoadImage(id);
//			
//			if(!list2.isEmpty()) {
//			ProductColor c = (ProductColor) list2.get(0).getGroup();		
//				model.addAttribute("checkColor", c.getColor().getId());
//			}
//			if(!list.isEmpty()) {
//				model.addAttribute("checkSize", list.get(0).getSize().getId());
//			}
			
			model.addAttribute("check", false);
			model.addAttribute("quality", 1);
			return "web/detail-book";
		}
		@PostMapping("detail-book/{id}")
		public String add(@PathVariable("id") long id, Model model, HttpServletRequest req) {
//			String color = req.getParameter("color");
//			String size = req.getParameter("size");
			String quality = req.getParameter("quality");
			System.out.println(quality);
			BookEntity product = bookDao.findBookByLongId(id);	
			
			Item entity = new Item();
			entity.setId(id);			
//			if(color!=null) {			
			entity.setImage(product.getImgBook());
			entity.setName(product.getName());
			entity.setPrice(product.getSalePrice());
			entity.setQuality(Integer.parseInt(quality));
			
			cart.add(id, entity);
			sessionService.set("countProduct", cart.getCount());
			
			req.setAttribute("quality", Integer.parseInt(quality));
			model.addAttribute("alert", "Thông báo!");
			model.addAttribute("content", "Sản phẩm đã được thêm vào giỏ hàng!");
			model.addAttribute("check", true);
			return "web/detail-book";
		}
		@PostMapping("/detail-book/post/new/{id}")
		public String addNew(@PathVariable("id") long id, Model model, HttpServletRequest req) {
//			String color = req.getParameter("color");
//			String size = req.getParameter("size");
			String content = req.getParameter("content");
			if(content!=null) {
				System.out.println(content);
				UserEntity user = sessionService.get("user");
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate = formatter.format(date);
				BookEntity product = bookDao.findBookByLongId(id);	
				NewEntity news= new NewEntity(strDate,content,user,product);
				newDao.save(news);	
				String con= user.getFullName().getFirstname()+" "+user.getFullName().getLastname()+"đã thêm một bình luận !";
				NotifEntity notif = new NotifEntity(con,strDate,date,userDao.getById((long)3),product,news); 
				notifDao.save(notif);
				return "redirect:/detail-book/{id}";
			}
			return "web/detail-book";
		}
		@RequestMapping("/detail-book/delete/new/{id}/{newId}")
		public String delete(Model model,@PathVariable("id") long id, @PathVariable("newId") long eid) {
			NewEntity news= newDao.getById(eid);
			
			
			notifDao.delete(notifDao.findNotifByNewId(eid));
			newDao.delete(news);
			return "redirect:/detail-book/{id}";
		}
		@ModelAttribute("loadInfo")
		public BookDetail loadInfo(@PathVariable("id") Long id, Model model){
			BookDetail entity = bookDao.findByLongId(id);
			return entity;
		}
		@ModelAttribute("category")
		public List<CategoryEntity> loadCategory(@PathVariable("id") Long id, Model model){
			List<CategoryEntity> list = bookCateDao.findListCateByBookId(id);
			return list;
		}
		@ModelAttribute("checkFavorite")
		public boolean checkFavorite(@PathVariable("id") Long id) {
			boolean check = false;
			UserEntity user = sessionService.get("user");
			//Product product = productDao.getById(id);
			if(user != null) {
				FavoriteEntity entity = favoriteDao.getFavorite(user.getId(), id);
				if(entity == null) {
					check = true;
				}
			}		
			return check;
		}

}
