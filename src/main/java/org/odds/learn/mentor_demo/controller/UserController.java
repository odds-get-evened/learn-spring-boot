package org.odds.learn.mentor_demo.controller;

import org.odds.learn.mentor_demo.entity.UserEntity;
import org.odds.learn.mentor_demo.repo.CustomerRepo;
import org.odds.learn.mentor_demo.repo.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/account/register")
	public String registration(Model model) {
		// assign user object to template
		model.addAttribute("user", new UserEntity());

		return "account/register";
	}

	@PostMapping("/account/register")
	public String procRegistration(@ModelAttribute("user") @Valid UserEntity user, BindingResult binder) {
		/*
		 * can assign the template model as an annotation argument
		 * instead of using the model object inside the endpoint method
		 * e.g., model.addAttribute("user", new UserEntity());
		 * using Model model as an argument in this method
		 */

		// capture validation errors
		if(binder.hasErrors()) {
			return "account/register";
		}

		// grab password and encode it
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// save to database
		userRepo.save(user);

		return "account/register-success";
	}
}
