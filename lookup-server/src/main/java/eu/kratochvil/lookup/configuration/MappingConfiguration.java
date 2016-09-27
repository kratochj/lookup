package eu.kratochvil.lookup.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
@Configuration
public class MappingConfiguration {

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBeanMapperFactoryBean() throws Exception {
		List<String> mappingFiles = Arrays.asList(
				"mappings/dozer-global-configuration.xml",
				"mappings/dozer-bean-mappings.xml"
		);
		final DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(mappingFiles);
		return dozerBeanMapper;
	}
}