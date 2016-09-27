package eu.kratochvil.lookup.service.impl;

import eu.kratochvil.lookup.Application;
import eu.kratochvil.lookup.entities.LogRequest;
import eu.kratochvil.lookup.entities.LogResponse;
import eu.kratochvil.lookup.service.LogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LogServiceImplTest {

	@Autowired
	private LogService logService;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Before
	public void before() {
		elasticsearchTemplate.deleteIndex(LogRequest.class);
		elasticsearchTemplate.createIndex(LogRequest.class);
		elasticsearchTemplate.putMapping(LogRequest.class);
		elasticsearchTemplate.refresh(LogRequest.class);
	}

	@Test
	public void testLogSend() throws Exception {
		LogRequest request = new LogRequest();
		request.setUuid("UUID1");

		LogResponse response = logService.send(request);
		assertNotNull(response);
		assertEquals("UUID1", response.getUuid());
	}
}
