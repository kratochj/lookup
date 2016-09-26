package eu.kratochvil.lookup.service.impl;

import eu.kratochvil.lookup.entities.LogRequest;
import eu.kratochvil.lookup.entities.LogResponse;
import eu.kratochvil.lookup.repository.LogRepository;
import eu.kratochvil.lookup.service.LogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogRepository logRepository;

	@Override
	public LogResponse send(LogRequest logRequest) {
		if (StringUtils.isBlank(logRequest.getUuid())) {
			logRequest.setUuid(UUID.randomUUID().toString());
		}
		logRequest.setTimestamp(new Date());

		logRepository.save(logRequest);

		return new LogResponse(logRequest.getUuid());
	}
}
