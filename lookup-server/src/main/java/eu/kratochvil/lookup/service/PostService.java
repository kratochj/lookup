package eu.kratochvil.lookup.service;

import eu.kratochvil.lookup.entities.Post;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
public interface PostService {
	Post save(Post post);

	Post findOne(String id);

	Iterable<Post> findAll();

}
