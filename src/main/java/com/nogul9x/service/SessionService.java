package com.nogul9x.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public interface SessionService {
	public static final HttpSession session = null;
	
	public default void set(String name, Object value) {
		session.setAttribute(name, value);
	}
	
	public default <T> T get(String name) {
		return (T) session.getAttribute(name);
	}
	
	public static void remove(String name) {
		session.removeAttribute(name);
	}
}
