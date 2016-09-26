package eu.kratochvil.lookup.service;

import eu.kratochvil.lookup.entities.LogRequest;
import eu.kratochvil.lookup.entities.LogResponse;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
public interface LogService {

	LogResponse send(LogRequest logRequest);

}
