package com.yoribogo.controller.list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/list")
public class ListController {
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model) {
		
		return "list/list";
	}
	
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		return "list/detail";
	}
	
}
