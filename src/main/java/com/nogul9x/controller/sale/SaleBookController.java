package com.nogul9x.controller.sale;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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
import com.nogul9x.dao.BookCate;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.PublisherDAO;
import com.nogul9x.entity.AuthorEntity;
import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.PublisherEntity;
import com.nogul9x.model.Book;
import com.nogul9x.model.BookDetail;
import com.nogul9x.service.ParamService;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.BookValidator;






@Controller
public class SaleBookController {
	@Autowired
	BookDAO bookDao;
	@Autowired
	BookCate bookcateDao;
	@Autowired
	PublisherDAO publisherDao;
	@Autowired
	AuthorDAO authorDao;
	@Autowired
	SessionServiceImpl session;

	@Autowired
	ParamService param;
	@Autowired
	BookValidator bookValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == Book.class) {
			binder.setValidator(bookValidator);
		}
	}
	@GetMapping("/sale/bookForm/form")
	public String index(Model model) {
		// session.set("nameImage3", "");
		session.set("idAuthor", "");
		session.set("idPublisher", "");
		session.set("pubDay", "");
		
		Book entity = new Book();
		model.addAttribute("bookForm", entity);
		return "sale/productForm";
	}
	@RequestMapping("/sale/bookTable/list")
	public String index(Model model, @RequestParam("keyword5") Optional<String> name,
			@RequestParam("p") Optional<Integer> p) {
		String findName;
		if (session.get("keyword5") == null) {
			findName = name.orElse("");
		} else {
			findName = name.orElse(session.get("keyword5"));
		}

		session.set("keyword5", findName);

		Pageable pageable = PageRequest.of(p.orElse(0), 5);

		Page<BookDetail> page = bookDao.fillToTable("%" + findName + "%", pageable);
		model.addAttribute("bookItem", page);

		return "sale/productTable";
	}
	@GetMapping("/sale/bookForm/list/load/{id}")
	public String load(Model model, @PathVariable("id") long id) {
		// Manufacture manufacture = dao.getById(id);
		BookEntity product = bookDao.findBookByLongId(id);
		// ManufactureModel entity = new ManufactureModel();
		Book entity = new Book();
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setInPrice(product.getInPrice());
		entity.setQuality(product.getQuality());
		entity.setDes(product.getDes());
		entity.setSalePrice(product.getSalePrice());
		entity.setAuthor(product.getAuthor().getName());
		entity.setPublisher(product.getPublisher().getName());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		session.set("pubDay",  df.format(product.getCreatedDate()));
		session.set("idAuthor", product.getAuthor().getId());
		session.set("idPublisher", product.getPublisher().getId());
		// Manufacture manufacture = manuDao.getById(product.getManufacture().getId());
		// entity.setManufacture(product.getManufacture().getName());
		// entity.setInformation(manufacture.getInformation());
		model.addAttribute("edit3", true);
		model.addAttribute("bookForm", entity);
		// session.set("nameImage2", manufacture.getImage());
		session.set("id3", product.getId());
		return "sale/productForm";
	}
	@PostMapping("/sale/bookForm/form")
	public String save(Model model, @ModelAttribute("bookForm") @Validated Book entity,
			BindingResult result) {
		if (result.hasErrors()) {
			return "sale/bookForm";
		}

		else {
			
				AuthorEntity author  = authorDao.getById(Long.parseLong(entity.getAuthor()));
				PublisherEntity publisher  = publisherDao.getById(Long.parseLong(entity.getPublisher()));
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			        Date date = null;
					try {
						date = sdf.parse(entity.getPubDay());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date today = new Date();
					int code;
					code= (int) Math.floor(((Math.random() * 99) + 100));;
					BookEntity product = new  BookEntity(code,"",date," ",today, entity.getName(),
							entity.getDes(),entity.getInPrice(), entity.getPrice(), entity.getSalePrice(),param.save(entity.getImgBook()), 
							entity.getQuality(),author,  publisher);
					bookDao.save(product);

		}
		return "redirect:/sale/bookTable/list";
		// return "manager/productForm";
	}

	@RequestMapping("/sale/bookForm/form/edit/{id}")
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute("bookForm") Book entity,
			BindingResult result) {
		model.addAttribute("edit3", true);
		if (entity.getName().isEmpty()) {
			result.rejectValue("name", "NotBlank.productForm.name");
		}
		
		if (entity.getPrice() == 0) {
			result.rejectValue("price", "NotBlank.productForm.price");
		}

		if (entity.getInPrice() ==0) {
			result.rejectValue("inPrice", "NotBlank.productForm.origin");
		}
		if (entity.getSalePrice()==0) {
			result.rejectValue("salePrice", "NotBlank.productForm.material");
		}
		if (entity.getDes().isEmpty()) {
			result.rejectValue("des", "NotBlank.productForm.describe");
		}
		if (entity.getQuality()==0) {
			result.rejectValue("quality", "NotNull.productForm.manuDay");
		}
		if (!result.hasErrors()) {
			// Manufacture manufacture = dao.getById(id);
			System.out.println(entity.getPubDay());
			String dateStr = entity.getPubDay();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = null;
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sdf = new SimpleDateFormat("yyyy-MM-dd");
	        dateStr = sdf.format(date);
	        
			BookEntity product = bookDao.findBookByLongId(id);
			product.setCreatedDate(date);
			product.setName(entity.getName());
			product.setPrice(entity.getPrice());
			product.setDes(entity.getDes());
			product.setInPrice(entity.getInPrice());
			product.setSalePrice(entity.getSalePrice());
			product.setQuality(entity.getQuality());
			
			System.out.println(entity.getAuthor());
			System.out.println(entity.getPublisher());
			AuthorEntity author  = authorDao.getById(Long.parseLong(entity.getAuthor()));
			product.setAuthor(author);
			PublisherEntity publisher  = publisherDao.getById(Long.parseLong(entity.getPublisher()));
			product.setPublisher(publisher);
			if (!entity.getImgBook().isEmpty()) {
				product.setImgBook(param.save(entity.getImgBook()));
			}
			bookDao.save(product);
			model.addAttribute("edit3", false);
			// session.set("nameImage3", "");
			return "redirect:/sale/bookTable/list";
		}

		return "sale/productForm";
	}
	@RequestMapping("/sale/bookTable/list/delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {
		BookEntity entity = bookDao.findBookByLongId(id);
		List <BookCateEntity> bookcates = bookcateDao.findListBookCateByBookId(id);
		for(BookCateEntity b : bookcates) {
			bookcateDao.delete(b);
		}
		bookDao.delete(entity);
		return "redirect:/sale/bookTable/list";
	}
	@RequestMapping("/sale/bookForm/refresh")
	public String refresh() {
		return "redirect:/sale/bookForm/form";
	}
	@GetMapping("/sale/bookTable/list/enable/{id}")
	public String enable(Model model, @PathVariable("id") long id) {
		BookEntity entity = bookDao.findBookByLongId(id);
		if(entity.getCreatedBy().equals("1")) {
			entity.setCreatedBy("0");
		}else {
			entity.setCreatedBy("1");		
		}
		bookDao.save(entity);
		return "redirect:/sale/bookTable/list";
	}
	@ModelAttribute("author")
	public Map<Long, String> author() {
		Map<Long, String> map = new HashMap();
		List<AuthorEntity> list = authorDao.findAll();
		for (AuthorEntity m : list) {
			map.put(m.getId(), m.getName());
		}
		return map;
	}
	@ModelAttribute("publisher")
	public Map<Long, String> publisher() {
		Map<Long, String> map = new HashMap();
		List<PublisherEntity> list = publisherDao.findAll();
		for (PublisherEntity m : list) {
			map.put(m.getId(), m.getName());
		}
		return map;
	}
}
