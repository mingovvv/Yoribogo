package com.yoribogo.controller.chef;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@RequestMapping("/chef/")
@Controller("ChefHomeController") /*식별자 한쪽만 / 식별 가능하면 됨 / 노트 컨트롤러가 두개가 존재하기에 생기는 문제*/
public class HomeController {
	
/*	@Autowired
	private NoteService service;//어나니머스들을 위한 노트서비스가 아님 이것도 2개인거야
*/	
	@GetMapping("index")//최신버전 get까지가능
	public String index(Integer page, Model model) {
		
		/*List<Note> note =service.getNoteList(page);
		model.addAttribute("notes" ,note);*/
		
		return "chef.index";
	}
	
}