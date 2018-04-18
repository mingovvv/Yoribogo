package com.yoribogo.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

@Component
public class YoribogoLoginSuccessHandler implements AuthenticationSuccessHandler{

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse renponse, Authentication authentication)
			throws IOException, ServletException {
		
		String memberId = authentication.getName();
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		System.out.println(memberId);
		for(String role : roles)
			System.out.println(role);
		
		//가려던길 알아보는 설정
				HttpSession session = request.getSession();
				if(session != null) {
					SavedRequest savedReqeust = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
					
					if(savedReqeust != null) {
						String returnUrl = savedReqeust.getRedirectUrl();
						System.out.println(returnUrl);
						
						redirectStrategy.sendRedirect(request, renponse, returnUrl);
					}
					else {
						redirectStrategy.sendRedirect(request, renponse, "/chef/index");
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
