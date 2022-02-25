package com.recipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.repository.PostRepository;
import com.recipe.vo.PostVO;

@Service
public class PostService {
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostRepository postRepository;
	
	public List<PostVO> getPost() {
		
		log.info("### Post Table Select Start ###");
		List<PostVO> postList = postRepository.findAll();
		log.info("### Post Table Select End   ###");
		
		return postList;
	}

}
