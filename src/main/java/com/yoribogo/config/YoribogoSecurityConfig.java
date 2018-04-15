package com.yoribogo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class YoribogoSecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	
	
	/* 인증을 위한*/ 
	@Override //스프링에서 지원해주는 로그인창으로 보내는것
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//UserBuilder users = User.withDefaultPasswordEncoder(); 사용자 pwd를 확인할때 텍스트로 확인해서 오류뜸
		UserBuilder users = User.builder();
		
		auth.inMemoryAuthentication().withUser(users.username("min").password("{noop}min").roles("CHEF"));
	}
	
	
	
}
