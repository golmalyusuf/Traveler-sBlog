package com.yusuf.travel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yusuf.travel.repository.PostStatusRepository;
import com.yusuf.travel.service.PostService;

@Controller
public class MainController {

	@Autowired
	PostService postService; 
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(HttpServletRequest request, Model model) {
		return home2(request, model);
	}
	
	@GetMapping("/index")
	public String home2(HttpServletRequest request, Model model) {
		model.addAttribute("allPublicPosts", postService.getAllPublicPosts());
		return "index";
	}
}
