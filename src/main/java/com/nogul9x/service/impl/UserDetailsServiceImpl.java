package com.nogul9x.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.BookDAO;
import com.nogul9x.dao.RoleDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.entity.BookEntity;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private BookDAO bookDao;
	@Autowired
	private RoleDAO roleDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AccountEntity	account = this.accountDao.findByEmail(username);
		
		if(account == null) {
			System.out.println("User not found! "+username);
			throw new UsernameNotFoundException("User " + username + " was not found in database");		
		} 
		else {
			System.out.println("User found! "+username);
		}
		
	//	System.out.println("Found User: "+appUser);
		
		List<String> roleNames = this.roleDao.getRoleNames(userDao.findUserByAccountId(account.getId()).getId());
		System.out.println(roleNames);
		List<GrantedAuthority> grandList = new ArrayList<GrantedAuthority>();
		System.out.println(account.getPassword());
		if(roleNames!=null) {
			for(String role: roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grandList.add(authority);
			}
		}
		
		UserDetails userDetails = (UserDetails) new User(account.getEmail(), account.getPassword(), grandList);
		System.out.println(userDetails);
		return userDetails;
	}

}
