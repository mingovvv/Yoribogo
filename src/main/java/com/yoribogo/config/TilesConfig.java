package com.yoribogo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration//설정이다
public class TilesConfig {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		
		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
		
		//preparer를 사용하기 위해서 써줌
		tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
		
		tilesConfigurer.setCheckRefresh(true); //잘모르겠다
		
		return tilesConfigurer;
		
	}
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		
		urlBasedViewResolver.setViewClass(TilesView.class);
		urlBasedViewResolver.setOrder(1);
		
		return urlBasedViewResolver;
		
	}
}
