package com.yusuf.travel.service;

import java.util.ArrayList;

import com.yusuf.travel.dto.PostStatusDto;
import com.yusuf.travel.model.Post;

public interface PostService {
	Post save(PostStatusDto postStatusDto); 
	public ArrayList<Post> getAllPublicPosts();
	public ArrayList<Post> getAllPostsByUser();
	PostStatusDto getPostById(long id);
}
