package eu.kratochvil.lookup.entities;

import java.util.UUID;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
public class LogResponse {

	// Always present: err
	// 0 indiciates that there was no error
	int err;

	// Always present: uuid
	// UUID of the posted occurrence.
	// If you provided one in the payload, this will be the value you provided
	// If you did not, one will be generated for you.
	// You can use this later to look up the occurrence by UUID.
	String uuid;

	public LogResponse(String uuid) {
		this.err = 0;
		this.uuid = uuid;
	}

	public int getErr() {
		return err;
	}

	public void setErr(int err) {
		this.err = err;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
