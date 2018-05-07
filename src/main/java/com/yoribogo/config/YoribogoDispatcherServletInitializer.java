package com.yoribogo.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class YoribogoDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {
				HibernateConfig.class,
				YoribogoSecurityConfig.class//보안 담당
		};
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {
				ServletContextConfig.class,//xml에서 contextConfigLocation를 담당
				YoribogoMvcConfig.class,
				TilesConfig.class
				
		};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	private Filter characterEncodingFilter() { /*import 자바xml서블릿*/
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return filter;
	}
	
	@Override /*한글깨짐 필터사용하겠다*/
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {
				characterEncodingFilter()
		};
	}

}
