package eu.kratochvil.lookup.repository;

import eu.kratochvil.lookup.entities.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
public interface PostRepository extends ElasticsearchCrudRepository<Post, String> {

}
