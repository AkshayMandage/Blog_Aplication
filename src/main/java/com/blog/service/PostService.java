package com.blog.service;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payloads.PostDto;

public interface PostService {

	// create

	Post createPost(PostDto postDto,Integer userId, Integer categoryId);

	// update post

	Post updatePost(PostDto postDto, Integer postId);

	// delete Post

	void deletePost(Integer postId);

	// get all Posts

	List<Post> getAllPost();

	// get single post

	Post getPostById(Integer postId);

	// get all posts by category

	List<Post> getPostsByCategory(Integer categoryId);

	// get all post by user

	List<Post> getPostsByUser(Integer userId);

	// search post

	List<Post> seachPosts(String keyword);

}
