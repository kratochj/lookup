package eu.kratochvil.lookup.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

/**
 * @author Jiri Kratochvil <jiri.kratochvil@topmonks.com>
 */
@Document(indexName = "log", type = "log", shards = 1, replicas = 0)
public class LogRequest {

	// Required: uuid
	// A string, up to 36 characters, that uniquely identifies this occurrence.
	// While it can now be any latin1 string, this may change to be a 16 byte field in the future.
	// We recommend using a UUID4 (16 random bytes).
	// The UUID space is unique to each project, and can be used to look up an occurrence later.
	// It is also used to detect duplicate requests. If you send the same UUID in two payloads, the second
	// one will be discarded.
	@Id
	String uuid;


	// An access token with scope "post_server_item" or "post_client_item".
	// A post_client_item token must be used if the "platform" is "browser", "android", "ios", "flash", or "client"
	// A post_server_item token should be used for other platforms.
	String accessToken;

	// Required: environment
	// The name of the environment in which this occurrence was seen.
	// A string up to 255 characters. For best results, use "production" or "prod" for your
	// production environment.
	// You don't need to configure anything in the Rollbar UI for new environment names;
	// we'll detect them automatically.
	String environment;

	// Required: body
	// The main data being sent. It can either be a message, an exception, or a crash report.
	LogRequestBody body;

	// Optional: level
	// The severity level. One of: "critical", "error", "warning", "info", "debug"
	// Defaults to "error" for exceptions and "info" for messages.
	// The level of the *first* occurrence of an item is used as the item's level.
	LogLevel level;

	// Optional: timestamp
	@Field(type = FieldType.Date, index = FieldIndex.not_analyzed, store = true,
			format = DateFormat.custom, pattern = "yyyyMMdd'T'HHmmss.SSSZ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyyMMdd'T'HHmmss.SSSZ")
	Date timestamp;

	// Optional: code_version
	// A string, up to 40 characters, describing the version of the application code
	// Rollbar understands these formats:
	// - semantic version (i.e. "2.1.12")
	// - integer (i.e. "45")
	// - git SHA (i.e. "3da541559918a808c2402bba5012f6c60b27661c")
	// If you have multiple code versions that are relevant, those can be sent inside "client" and "server"
	// (see those sections below)
	// For most cases, just send it here.
	String codeVersion;

	// Optional: platform
	// The platform on which this occurred. Meaningful platform names:
	// "browser", "android", "ios", "flash", "client", "heroku", "google-app-engine"
	// If this is a client-side event, be sure to specify the platform and use a post_client_item access token.
	String platform;

	// Optional: language
	// The name of the language your code is written in.
	// This can affect the order of the frames in the stack trace. The following languages set the most
	// recent call first - 'ruby', 'javascript', 'php', 'java', 'objective-c', 'lua'
	// It will also change the way the individual frames are displayed, with what is most consistent with
	// users of the language.
	String language;

	// Optional: framework
	// The name of the framework your code uses
	String framework;

	// Optional: request
	// Data about the request this event occurred in.
//	LogRequest request;
//
//	LogPerson person;
//
//	LogServer server;
//
//	LogClient client;
//
	// Optional: fingerprint
	// A string controlling how this occurrence should be grouped. Occurrences with the same
	// fingerprint are grouped together. See the "Grouping" guide for more information.
	// Should be a string up to 40 characters long; if longer than 40 characters, we'll use its SHA1 hash.
	// If omitted, we'll determine this on the backend.
	String fingerprint;


	// Optional: title
	// A string that will be used as the title of the Item occurrences will be grouped into.
	// Max length 255 characters.
	// If omitted, we'll determine this on the backend.
	String title;

	// Optional: notifier
	// Describes the library used to send this event.
//	LogNotifier notifier;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public LogRequestBody getBody() {
		return body;
	}

	public void setBody(LogRequestBody body) {
		this.body = body;
	}

	public LogLevel getLevel() {
		return level;
	}

	public void setLevel(LogLevel level) {
		this.level = level;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCodeVersion() {
		return codeVersion;
	}

	public void setCodeVersion(String codeVersion) {
		this.codeVersion = codeVersion;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
