package eu.kratochvil.lookup.repository;

import eu.kratochvil.lookup.entities.LogRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
public interface LogRepository extends ElasticsearchCrudRepository<LogRequest, String> {
}
