package com.yusuf.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.travel.dto.PostStatusDto;
import com.yusuf.travel.model.Locations;
import com.yusuf.travel.model.User;
import com.yusuf.travel.repository.LocationsRepository;
import com.yusuf.travel.service.LocationService;
import com.yusuf.travel.service.PostService;

@Controller
@RequestMapping("/poststatusform")
public class PostController {
	  
	@Autowired
	LocationsRepository locationRepo; 
	
	private PostService postService;
	
	public PostController(PostService postService) { 
		this.postService = postService;
	}
	
	@ModelAttribute("locationList") 
	public List<Locations> locaitonList() { 
		  List<Locations> loclist = locationRepo.findAll();
		return loclist; 
	}
	
	@ModelAttribute("post") 
	public PostStatusDto postStatusDto() { 
		  PostStatusDto psd = new PostStatusDto(); 
		  return psd; 
	}
	
	
	@GetMapping
	public String showStatusForm() { 
		  return "statusform"; 
	}
	  
	@PostMapping 
	public String postUserStatus(@ModelAttribute("post")
    PostStatusDto postStatusDto) { 
		postService.save(postStatusDto); 
		return "redirect:index"; 
    }
	
	@RequestMapping("/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") long id) {
	    ModelAndView mav = new ModelAndView("statusFormEdit");
	    PostStatusDto postStatusDto = postService.getPostById(id);
	    mav.addObject("postStatusDto", postStatusDto );
	    return mav;
	}
	 
}
