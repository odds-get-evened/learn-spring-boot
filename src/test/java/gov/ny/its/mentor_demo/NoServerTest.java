package gov.ny.its.mentor_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * the same as HttpRequestTest.java, but is serverless. tests against the framework code
 * instead of the server instance.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class NoServerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mvc.perform(get("/smoke-test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
}
