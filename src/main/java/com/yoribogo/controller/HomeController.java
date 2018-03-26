package com.yoribogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
//루트디렉토리에 있는걸 맵핑함
public class HomeController {
	@RequestMapping("index")
	public String aaa() {
		return "index";	
	}
}