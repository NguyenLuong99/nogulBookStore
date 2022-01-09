package com.nogul9x.validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.model.GooglePojo;
import com.nogul9x.model.LoginUser;
import com.nogul9x.service.impl.SessionServiceImpl;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

@Component
public class LoginFormValidator implements Validator {
	@Autowired
	private UserDAO dao;
	@Autowired 
	private AccountDAO accountDao;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private Environment env;
	@Autowired
	SessionServiceImpl session;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == LoginUser.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoginUser entity = (LoginUser) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotBlank.userLogin.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.userLogin.password");

		if (!errors.hasFieldErrors()) {
			AccountEntity account = accountDao.findByEmail(entity.getUsername());
			if (account == null) {
				errors.rejectValue("username", "NotFind.userLogin.username");
				errors.rejectValue("password", "NotFind.userLogin.password");
			}
			else {
			//	passwordEncoder.matches(user.getPassword(), entity.getPassword())
//				if(user.getPassword().equals(entity.getPassword()) == false) {
				if(passwordEncoder.matches(entity.getPassword(), account.getPassword()) == false) {
					errors.rejectValue("password", "NotFind.userLogin.password");
				}
				//errors.rejectValue("password", "NotFind.userLogin.password");
			}
		}

	}


	public String getToken(final String code) throws ClientProtocolException, IOException {
		String link = env.getProperty("google.link.get.token");

		String response = Request.Post(link)
				.bodyForm(Form.form().add("client_id", env.getProperty("google.app.id"))
						.add("client_secret", env.getProperty("google.app.secret"))
						.add("redirect_uri", env.getProperty("google.redirect.uri")).add("code", code)
						.add("grant_type", "authorization_code").build())
				.execute().returnContent().asString();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
		return node.textValue();
	}

	public GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = env.getProperty("google.link.get.user_info") + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		GooglePojo googlePojo = mapper.readValue(response, GooglePojo.class);
		System.out.println(googlePojo);
		return googlePojo;

	}

	public UserDetails buildUser(GooglePojo googlePojo) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails userDetail = new User(googlePojo.getName(),
				"", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return userDetail;
	}

	public String getFbToken(final String code) throws ClientProtocolException, IOException {
		String link = String.format(env.getProperty("facebook.link.get.token"), env.getProperty("facebook.app.id"),
				env.getProperty("facebook.app.secret"), env.getProperty("facebook.redirect.uri"), code);
		String response = Request.Get(link).execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
		return node.textValue();
	}

	public com.restfb.types.User getFbUserInfo(final String accessToken) {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken, env.getProperty("facebook.app.secret"),
				Version.LATEST);
		return facebookClient.fetchObject("me", com.restfb.types.User.class);
	}
	
	public UserDetails buildUser(com.restfb.types.User user) {
		System.out.println(user);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails userDetail = new User(user.getId() + "_" +user.getName(), "", enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		System.out.println(userDetail);
		return userDetail;
	}


}
