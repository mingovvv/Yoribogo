package com.yoribogo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.yoribogo.config")
public class YoribogoSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired /*콩에 담긴거 쓰기*/
	private AuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()
			.authorizeRequests()//인증을 요청
			//-----------------------------------
			.antMatchers("/*","/recipe/**","/member/**").permitAll()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/chef/**").hasRole("CHEF")//access("hasRole('AUTHOR') or hasRole('ADMIN')").hasRole("AUTHOR")
			//-----------------------------------
			//.anyRequest().authenticated()//기본 설정(모든것을 다 막아버리기)
			.and()
		.formLogin()//로그인 폼 설정
			.loginPage("/member/login") // get
			.loginProcessingUrl("/member/login") //post
			.successHandler(successHandler) // 로그인성공하고 발생하는 핸들러
			//.defaultSuccessUrl("/index")//로그인시 디폴트 이동값
			.permitAll()
			
			
			.and()
		.logout()
			//.logoutUrl("/member/logout") //내가 정해주는 로그아웃 URL
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true);
	}
	
	
	
	
	/* 인증을 위한*/ 
	@Override //스프링에서 지원해주는 로그인창으로 보내는것
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//UserBuilder users = User.withDefaultPasswordEncoder(); 사용자 pwd를 확인할때 텍스트로 확인해서 오류뜸
		UserBuilder users = User.builder();
		
		auth.inMemoryAuthentication().withUser(users.username("min").password("{noop}min").roles("CHEF"));
	}
	
	
	
}
