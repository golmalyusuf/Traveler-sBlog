package com.yusuf.travel.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yusuf.travel.dto.UserRegistrationDto;
import com.yusuf.travel.model.User;
import com.yusuf.travel.repository.UserRepository;
import com.yusuf.travel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		User user = new User(userRegistrationDto.getFirstName(), 
				userRegistrationDto.getLastName(), userRegistrationDto.getEmail(), passwordEncoder.encode(userRegistrationDto.getPassword()), "USER_ROLE");
		return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User user = userRepository.findByEmail(email);
		 if(user == null) {
			 throw new UsernameNotFoundException("Invalid email or password!!!");
		 }
		 
		 return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities("USER_ROLE"));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role){
		SimpleGrantedAuthority roleTemp = new SimpleGrantedAuthority(role);
		ArrayList<GrantedAuthority>  gArrayList = new ArrayList<GrantedAuthority>();
		gArrayList.add(roleTemp);
		return gArrayList;
	}
}
