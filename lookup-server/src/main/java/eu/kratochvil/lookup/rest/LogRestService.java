package eu.kratochvil.lookup.rest;

import eu.kratochvil.lookup.ReceivingLogException;
import eu.kratochvil.lookup.api.LogRequest;
import eu.kratochvil.lookup.api.LogResponse;
import eu.kratochvil.lookup.service.LogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
@RestController
@RequestMapping("/rest/logger")
public class LogRestService {
	public static final Logger logger = LogManager.getLogger(LogRestService.class);

	@Autowired
	Mapper mapper;

	@Autowired
	LogService logService;

	@RequestMapping(method = RequestMethod.POST)
	public LogResponse log(LogRequest request) throws ReceivingLogException {
		try {
			return mapper.map(logService.send(mapper.map(request, eu.kratochvil.lookup.entities.LogRequest.class)), LogResponse.class);
		} catch (Exception e) {
			logger.error("Error receiving log: {}", e.getMessage(), e);
			throw new ReceivingLogException(e.getMessage(), e);
		}
	}

}
