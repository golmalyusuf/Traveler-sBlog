package com.yusuf.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yusuf.travel.dto.UserRegistrationDto;
import com.yusuf.travel.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userservice;

	public UserRegistrationController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto regDto) {
		userservice.save(regDto);
		return "redirect:registration?success";
	}
}
