package com.yusuf.travel.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yusuf.travel.model.Post;

@Repository
public interface PostStatusRepository extends JpaRepository<Post, Long> {

	@Query(value = "select * from posts where user_id = ?1",nativeQuery = true)
	ArrayList<Post> findByUserId(@Param("user_id")long user_id);

	@Query(value = "select * from posts where privacy_id != 1",nativeQuery = true)
	ArrayList<Post> findAllPublicPosts(@Param("user_id")long user_id);
	
} 
