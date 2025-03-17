package gov.ny.its.mentor_demo.config;

import gov.ny.its.mentor_demo.util.SHAPasswordEncoder;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MentorAppConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new SHAPasswordEncoder();
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
