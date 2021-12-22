package com.mkriiger.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkriiger.workshopmongo.domain.Post;
import com.mkriiger.workshopmongo.repository.PostRepository;
import com.mkriiger.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		//return postRepository.findByTitleCustom(text);
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		//necessário acrescentar 24hs em milissegundos para que n busque apenas até o dia anterior
		maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 1000));
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
