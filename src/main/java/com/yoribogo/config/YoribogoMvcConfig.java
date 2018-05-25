package com.yoribogo.config;


import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration /*설정을 가지고 있는 놈이다*/
@EnableWebMvc /*이것을 넣지 않으면 mvc는 일을하지않는다*/
public class YoribogoMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resources/**") //이놈한테 접근하면
		.addResourceLocations("/resources/"); //이놈한테 가서 찾아봐라
		
	}
	
	//responsebody 한글깨짐 설정
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

	final StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
	    Charset.forName("UTF-8"));
	    stringHttpMessageConverter.setWriteAcceptCharset(false);

	    converters.add(stringHttpMessageConverter);
	    WebMvcConfigurer.super.configureMessageConverters(converters);
	}
	
}
