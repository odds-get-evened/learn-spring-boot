package gov.ny.its.mentor_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * primary configuration for application security
 */
@Configuration
@EnableWebSecurity
public class MentorSecurityConfig {
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> {
			auth.requestMatchers("/login/**", "/account/register", "/logout", "/error").permitAll();
			auth.requestMatchers("/secret/**").authenticated();
			auth.anyRequest().permitAll();
		});

		/**
		 * important to use a logout form in templates
		 * or you will have to force users to confirm logout.
		 * an unnecessary extra step
		 */
		http.logout((logout) -> {
			logout.logoutUrl("/logout");
			logout.logoutSuccessUrl("/");
			logout.invalidateHttpSession(true);
			logout.deleteCookies("JSESSIONID");
		});

		// assign the Okta login to the security instance
		http.oauth2Login(Customizer.withDefaults());

		return http.build();
	}
}
