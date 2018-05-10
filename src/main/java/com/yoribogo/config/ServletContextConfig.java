package com.yoribogo.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration /*설정을 가지고 있는 놈이다*/
@ComponentScan(basePackages="com.yoribogo.controller")/*컴포넌트 스캔을 담당하는놈*/

public class ServletContextConfig {
	
	@Bean /*포대자루에 담는다*/
	public InternalResourceViewResolver internalResourceViewResolver(){/*빈객체의 이름을 그대로 가져온다*/
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class); //이해 잘 안됨
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		
		
		return resolver;
		
	}
	
	@Bean /*한글깨짐 필터 생성*/
	public Filter characterEncodingFilter() { /*import 자바xml서블릿*/
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return filter;
	}
	
	@Bean(name = "multipartResolver") /*멀티파트*/
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    resolver.setMaxUploadSize(10485760);
	    resolver.setMaxInMemorySize(10485760);
	    return resolver;
	}
	
}

