package com.yoribogo.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller("RecipeController")
@RequestMapping("/recipe/")
public class RecipeController {
	

	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model) {
		//String page = request.getParameter("p"); 이렇게 안해두 됨
		
		//List<Note> notes = service.getNoteList(1);
		//model.addAttribute("notes",notes); //모델을 담아주는 역할 컨트롤러에 이미 모델이 있다 
		
		return "recipe.list"/*"note/list"*/; //뷰를 반환하는 형태
	}
	
	@RequestMapping("{id}")//경로 설정
	public String detail(@PathVariable("id") Integer id, Model model) { //파라미터 말고 주소 url때문에
		
		
		return "recipe.detail";
		
	}

}
