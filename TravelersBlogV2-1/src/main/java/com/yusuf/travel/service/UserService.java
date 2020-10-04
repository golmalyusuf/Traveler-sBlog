package com.yusuf.travel.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.yusuf.travel.dto.UserRegistrationDto;
import com.yusuf.travel.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto userRegistrationDto);
}
