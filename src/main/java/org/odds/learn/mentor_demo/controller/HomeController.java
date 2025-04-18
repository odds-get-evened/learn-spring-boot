package org.odds.learn.mentor_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * for smoke-testing and endpoint(s) (see test packages)
	 * @return a string
	 */
	@GetMapping("/smoke-test")
	public @ResponseBody String smokeTest() {
		return "Hello, World";
	}

	@GetMapping("/user/login")
	public String userLogin() { return "user/login"; }

	@GetMapping("/login/oauth2/code/okta")
	public String ssoLoginSuccess() {
		return "redirect:/secret/place";
	}

	@GetMapping("/secret/place")
	public String secretPlace(@AuthenticationPrincipal OidcUser principal) {
		return "secret/place";
	}

	// placeholder for Okta logout process
	@PostMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}

		return "redirect:/";
	}
}
