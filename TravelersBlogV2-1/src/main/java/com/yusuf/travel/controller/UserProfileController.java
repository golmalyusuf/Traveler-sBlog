package com.yusuf.travel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yusuf.travel.service.PostService;

@Controller
public class UserProfileController {
	@Autowired
	PostService postService; 
	
	@GetMapping("/userPorfile")
	public String home2(HttpServletRequest request, Model model) {
		model.addAttribute("allPostsByUser", postService.getAllPostsByUser());
		return "userPorfile";
	}
}
