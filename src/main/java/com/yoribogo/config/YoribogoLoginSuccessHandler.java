package com.yoribogo.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.yoribogo.service.MemberService;

@Component
public class YoribogoLoginSuccessHandler implements AuthenticationSuccessHandler{

	
	
	
	
	@Autowired
	private MemberService service;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse renponse, Authentication authentication)
			throws IOException, ServletException {
		
		String memberId = authentication.getName();
		
		System.out.println("아이디 = " +  memberId);
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		for(String role : roles)
			System.out.println(role);
		
		//가려던길 알아보는 설정
		HttpSession session = request.getSession();
		if(session != null) {
			SavedRequest savedReqeust = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			
			if(savedReqeust != null) {
				String returnUrl = savedReqeust.getRedirectUrl();
				System.out.println(returnUrl);
				Cookie cookie = new Cookie("login", "ok");
				renponse.addCookie(cookie);
				
				redirectStrategy.sendRedirect(request, renponse, returnUrl);
			}
			else { //직접 로그인창으로 간 경우
				
				Cookie cookie = new Cookie("login", "ok");
				renponse.addCookie(cookie);
				System.out.println(renponse);
				redirectStrategy.sendRedirect(request, renponse, "/chef/index");
				
				
				//-------------------------나중에 복합키에 대해 자세히 알게되면 구현-------------------
				//String defaultRole = service.getDefaultRoleByMemberId(memberId);
				
			/*	if(defaultRole=="ROLE_ADMIN") {
					redirectStrategy.sendRedirect(request, renponse, "/admin/index");
				}*/
				/*switch(defaultRole) {
				case "ROLE_CHEF":
					redirectStrategy.sendRedirect(request, renponse, "/chef/index");
					break;
				case "ROLE_ADMIN" :
					redirectStrategy.sendRedirect(request, renponse, "/index");
					break;
				default :
					break;
				}*/
				//-------------------------나중에 복합키에 대해 자세히 알게되면 구현-------------------
			}
					
					/*
					
					else { 
						
						
						
						
						//직접 로그인창으로 간 경우
						String defaultRole = service.getDefaultRoleByMemberId(memberId);
						
						if(defaultRole=="ROLE_ADMIN") {
							redirectStrategy.sendRedirect(request, renponse, "/admin/index");
						}
						switch(defaultRole) {
						case "ROLE_CHEF":
							redirectStrategy.sendRedirect(request, renponse, "/chef/index");
							break;
							
						default :
							break;
						}
					}
				
					*/
					
					
					
					
					}
			}
		}
