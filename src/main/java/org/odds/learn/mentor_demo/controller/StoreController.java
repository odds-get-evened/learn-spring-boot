package org.odds.learn.mentor_demo.controller;

import org.odds.learn.mentor_demo.entity.AlbumEntity;
import org.odds.learn.mentor_demo.entity.CustomerEntity;
import org.odds.learn.mentor_demo.repo.AlbumRepo;
import org.odds.learn.mentor_demo.repo.CustomerRepo;
import jakarta.validation.Valid;
import javassist.NotFoundException;
import org.odds.learn.mentor_demo.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class StoreController {
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private AlbumRepo albumRepo;

	@Autowired
	private SongRepo songRepo;

	@GetMapping("/store/customers")
	public String customerList(Model model) {
		// get all customers from the database
		List<CustomerEntity> customers = customerRepo.findAll();
		// assign the Java object to the HTML template
		model.addAttribute("customers", customers);

		return "store/customers";
	}

	@GetMapping("/store/customer/add")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new CustomerEntity());

		return "store/customer/add";
	}

	@PostMapping("/store/customer/add")
	public String procAddCustomer(@Valid CustomerEntity customer, BindingResult res, Model model) {
		// save form data back to database
		customerRepo.save(customer);

		return "redirect:/store/customers";
	}

	@GetMapping("/store/customer/edit/{id}")
	public String editCustomer(@PathVariable("id") Long id, Model model) throws NotFoundException {
		// grab the user entity by the ID passed in thru the path
		CustomerEntity customer = customerRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user ID: ".concat(Long.toString(id))));

		// assign entity to template
		model.addAttribute("customer", customer);

		return "store/customer/edit";
	}

	@PostMapping("/store/customer/edit/{id}")
	public String procEditCustomer(@PathVariable("id") Long id, @Valid @ModelAttribute("customer") CustomerEntity customer, BindingResult form) {
		if(form.hasErrors()) {
			// go back to GET endpoint
			return "store/customer/edit";
		}

		customer.setId(id);
		customerRepo.save(customer);

		return "redirect:/store/customers";
	}

	@GetMapping("/store/customer/remove/{id}")
	public String deleteCustomer(@PathVariable(value = "id") Long id) {
		customerRepo.deleteById(id);

		return "redirect:/store/customers";
	}

	@GetMapping("/store/customer/details/{id}")
	public String customerDetails(@PathVariable(value = "id") Long id, Model template) throws NoSuchElementException {
		//Optional<CustomerEntity> customer = customerRepo.findById(id);
		CustomerEntity customer = customerRepo.findById(id).orElseThrow();
		template.addAttribute("customer", customer);

		return "store/customer/details";
	}

	@GetMapping("/store/albums")
	public String viewAlbums(Model m) {
		List<AlbumEntity> albums = albumRepo.findAll();
		m.addAttribute("albums", albums);

		return "store/albums";
	}

	@GetMapping("/store/albums/with_lyrics")
	public String albumsWithLyrics(Model m) {
		List<AlbumEntity> albums = albumRepo.albumsWithLyrics();
		m.addAttribute("albums", albums);

		return "store/albums";
	}

	@GetMapping("/store/albums/details/{id}")
	public String albumDetails(@PathVariable(value = "id") Long id, Model m) throws NoSuchElementException {
		AlbumEntity album = albumRepo.findById(id).orElseThrow();
		m.addAttribute("album", album);

		return "store/albums/details";
	}
}
