package eu.kratochvil.lookup.service.impl;

import eu.kratochvil.lookup.entities.Post;
import eu.kratochvil.lookup.repository.PostRepository;
import eu.kratochvil.lookup.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post save(Post post) {
		postRepository.save(post);
		return post;
	}

	@Override
	public Post findOne(String id) {
		return postRepository.findOne(id);
	}

	@Override
	public Iterable<Post> findAll() {
		return postRepository.findAll();
	}

}