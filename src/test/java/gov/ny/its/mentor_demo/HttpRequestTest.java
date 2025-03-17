package gov.ny.its.mentor_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// test at the application service layer
// basically spins the Tomcat server up and tests all @Test methods
// good for assertions against HTTP request endpoints with expected results
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void greetingShouldReturnDefaultMessage() {
		// check for valid text on a specific endpoint
		assertThat(
				this.restTemplate.getForObject(
						"http://localhost:".concat(String.valueOf(port)).concat("/smoke-test"),
						String.class
				)).contains("Hello, World");
	}
}
