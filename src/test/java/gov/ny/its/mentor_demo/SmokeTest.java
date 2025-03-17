package gov.ny.its.mentor_demo;

import gov.ny.its.mentor_demo.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * simply tests to see if the controller(s) exist for sanity-checking.
 */
@SpringBootTest
public class SmokeTest {
	@Autowired
	private HomeController controller;

	@Test
	public void contextLoads() {
		// test to see if controller has been created by the application
		assertThat(controller).isNotNull();
	}
}
