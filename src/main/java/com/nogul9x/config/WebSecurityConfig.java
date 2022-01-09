package com.nogul9x.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nogul9x.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailService;

	@Autowired
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/faq", "/login", "/register", "/forgot-password").permitAll();

		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.

		http.authorizeRequests().antMatchers("/my-profile/**","/my-favorites/**" ,"/check-out","/my-order/**","/my-address/**")
				.access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_SALE')");

		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/sale/**").access("hasRole('ROLE_SALE')");
		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403page");
		// http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()
				// .loginProcessingUrl("/login")
				.loginPage("/login")
				// .failureUrl("/login")
				.usernameParameter("username").passwordParameter("password")
				// .failureUrl("/login")
				.failureForwardUrl("/login").defaultSuccessUrl("/successLogin", true)

				

//				.and().rememberMe().key("rem-me-key").rememberMeParameter("remember") // it is name of checkbox at login
//																						// page
//				.rememberMeCookieName("rememberlogin") // it is name of the cookie
//				.tokenValiditySeconds(1 * 24 * 60 * 60) // remember for number of seconds
		
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/faq");

		// Cấu hình Remember Me.
//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	}

	// Token stored in Memory (Of Web Server).
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//	    InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
//	    return memory;
//	}

}
