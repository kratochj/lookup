package eu.kratochvil.lookup.entities;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
public class LogRequestBody {

	/**
	 * Required: "trace", "trace_chain", "message", or "crash_report" (exactly one)
	 * If this payload is a single exception, use "trace"
	 * If a chain of exceptions (for languages that support inner exceptions), use "trace_chain"
	 * If a message with no stack trace, use "message"
	 * If an iOS crash report, use "crash_report"
	 */
	LogBodyType type;


	public LogBodyType getType() {
		return type;
	}

	public void setType(LogBodyType type) {
		this.type = type;
	}
}
