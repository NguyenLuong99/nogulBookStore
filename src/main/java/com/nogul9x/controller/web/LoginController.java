package com.nogul9x.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.FbAccountDAO;
import com.nogul9x.dao.GGAccountDAO;
import com.nogul9x.dao.RoleDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.dao.UserRoleDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.entity.AddressEntity;
import com.nogul9x.entity.FbAccountEntity;
import com.nogul9x.entity.FullNameEntity;
import com.nogul9x.entity.GGAccountEntity;
import com.nogul9x.entity.RoleEntity;
import com.nogul9x.entity.UserEntity;
import com.nogul9x.entity.UserRole;
import com.nogul9x.model.Address;
import com.nogul9x.model.GooglePojo;
import com.nogul9x.model.LoginUser;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.nogul9x.validator.LoginFormValidator;

@Controller
public class LoginController {
	@Autowired
	AccountDAO accountDao;
	@Autowired
	GGAccountDAO ggAccountDao;
	@Autowired
	FbAccountDAO fbAccountDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	GGAccountDAO ggDao;
	@Autowired
	RoleDAO roleDao;
	@Autowired
	UserRoleDAO userRoleDao;
	@Autowired
	LoginFormValidator loginValidator;
	@Autowired
	private SessionServiceImpl sessionService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if(target == null) {
			return;
		}
		if(target.getClass()==LoginUser.class) {
			binder.setValidator(loginValidator);
		}
	}

//	   @RequestMapping(value = "/login", method = RequestMethod.GET)
//       public ModelAndView faqPage() {
//              ModelAndView mav = new ModelAndView("web/login");
//              return mav;
//       }
		@GetMapping("/login")
		public String index(Model model) {
			sessionService.set("code", "Asdsfdsf2=-##2");
			LoginUser entity = new LoginUser();
			model.addAttribute("LoginUser", entity);
			return "web/login";
		}
		
	   @PostMapping("/login")
		public String signIn(Model model, @ModelAttribute("LoginUser") @Validated LoginUser entity,BindingResult result) {
			if(result.hasErrors()) {
				System.out.println("sai"+entity);
				return "web/login";
				
			}
			System.out.println("đã đăng nhập");
			System.out.println(entity.getUsername());
			AccountEntity account = accountDao.findByEmail(entity.getUsername());
			sessionService.set("account",account);
			String img ="https://scontent.fhan5-7.fna.fbcdn.net/v/t1.30497-1/143086968_2856368904622192_1959732218791162458_n.png?_nc_cat=1&ccb=1-5&_nc_sid=7206a8&_nc_ohc=3dulhYS2xWgAX98Yk3S&_nc_ht=scontent.fhan5-7.fna&oh=7e8465be1b0ffa6ac454ed4be41b7b5e&oe=61D93578";
			LoginUser user = new LoginUser(account.getFullname(),img);
			sessionService.set("userLogin",user);
			System.out.println(account);
			return "redirect:/faq";
	 }
	   @RequestMapping("/login-google")
		public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
			String code = request.getParameter("code");
			
			if (code == null || code.isEmpty()) {
				return "redirect:/login?google=error";
			}

			String accessToken = loginValidator.getToken(code);
			
			GooglePojo googlePojo = loginValidator.getUserInfo(accessToken);
			GGAccountEntity google = ggAccountDao.findByEmail(googlePojo.getEmail());
			
			if(google==null) {
				GGAccountEntity ggAccount= new GGAccountEntity(googlePojo.getEmail(),"",googlePojo.getName(),"2",googlePojo.getPicture(),googlePojo.getLocale());
				ggAccountDao.save(ggAccount);
				sessionService.set("account",ggAccount);
				AddressEntity address = new AddressEntity(googlePojo.getEmail());
				FullNameEntity fullname = new FullNameEntity(googlePojo.getFamily_name(),googlePojo.getGiven_name());
				UserEntity user = new UserEntity(address,fullname,ggAccount);
				userDao.save(user);
				RoleEntity role = roleDao.getOne((long)2);
				UserRole userRole = new UserRole(user, role);
				userRoleDao.save(userRole);
				System.out.println("dúng"+ggAccount);
			}
				UserEntity userEntity= userDao.findUserByGGAccountId(google.getId());
				sessionService.set("user",userEntity);
				sessionService.set("account",google);
			UserDetails userDetail = loginValidator.buildUser(googlePojo);
			LoginUser user = new LoginUser( userDetail.getUsername(),googlePojo.getPicture());
			sessionService.set("userLogin",user);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
					userDetail.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/faq";
		}
		@RequestMapping("/login-facebook")
		public String loginFacebook(HttpServletRequest request) throws ClientProtocolException, IOException {
			String code = request.getParameter("code");
			
			if (code == null || code.isEmpty()) {
				return "redirect:/login?facebook=error";
			}

			String accessToken = loginValidator.getFbToken(code);			
			com.restfb.types.User user =  loginValidator.getFbUserInfo(accessToken);
			FbAccountEntity facebook= fbAccountDao.findByFullName(user.getName());
			if(facebook==null){
				FbAccountEntity fbAccount= new FbAccountEntity("","",user.getName(),"3","");
				sessionService.set("account",fbAccount);
				fbAccountDao.save(fbAccount);
				FullNameEntity fullname = new FullNameEntity(user.getFirstName(),user.getLastName());
				AddressEntity address =new AddressEntity("");
				UserEntity userEntity = new UserEntity(address,fullname,fbAccount);
				userDao.save(userEntity);
				RoleEntity role = roleDao.getOne((long)2);
				UserRole userRole = new UserRole(userEntity, role);
				userRoleDao.save(userRole);
				System.out.println("dúng"+fbAccount);				
			}
				sessionService.set("account",facebook);
				UserEntity userEntity= userDao.findUserByFbAccountId(facebook.getId());
				sessionService.set("Login",userEntity.getId());
			String img ="https://scontent.fhan5-7.fna.fbcdn.net/v/t1.30497-1/143086968_2856368904622192_1959732218791162458_n.png?_nc_cat=1&ccb=1-5&_nc_sid=7206a8&_nc_ohc=3dulhYS2xWgAX98Yk3S&_nc_ht=scontent.fhan5-7.fna&oh=7e8465be1b0ffa6ac454ed4be41b7b5e&oe=61D93578";
			LoginUser userfb = new LoginUser(user.getName(),img);
			sessionService.set("userLogin",userfb);
			UserDetails userDetail =  loginValidator.buildUser(user);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
					userDetail.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:https://localhost:8443/faq";
		}
}
