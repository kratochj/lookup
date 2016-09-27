package eu.kratochvil.lookup.rest;

import eu.kratochvil.lookup.api.*;
import eu.kratochvil.lookup.service.LogService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogRestServiceTest {

	@InjectMocks
	LogRestService restService;

	@Mock
	LogService service;

	Mapper mapper;

	@Before
	public void setUp() throws Exception {
		List<String> mappingFiles = Arrays.asList(
				"mappings/dozer-global-configuration.xml",
				"mappings/dozer-bean-mappings.xml"
		);
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(mappingFiles);
		mapper = dozerBeanMapper;

		restService.mapper = mapper;
	}

	@Test
	public void testLog() throws Exception {
		LogRequestBody requestBody = new LogRequestBody();
		requestBody.setType(LogBodyType.CRASH_REPORT);

		LogRequest request = new LogRequest();
		request.setAccessToken("1234567890");
		request.setLevel(LogLevel.ERROR);
		request.setBody(requestBody);
		request.setUuid("UUID1");

		when(service.send(any())).thenReturn(new eu.kratochvil.lookup.entities.LogResponse("UUID1"));

		LogResponse response = restService.log(request);

		assertNotNull(response);
		assertEquals("UUID1", response.getUuid());
	}
}