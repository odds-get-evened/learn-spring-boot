package gov.ny.its.mentor_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
	@Autowired
	private Environment env;

	public String getHost() {
		return env.getProperty("server.address", "localhost");
	}

	public int getPort() {
		return env.getProperty("server.port", Integer.class, 8080);
	}
}
