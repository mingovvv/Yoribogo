package com.yoribogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
//��Ʈ���丮�� �ִ°� ������
public class HomeController {
	@RequestMapping("index")
	public String aaa() {
		return "index";	
	}
}