package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.entity.CustomerEntity;
import gov.ny.its.mentor_demo.repo.CustomerRepo;
import jakarta.validation.Valid;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepo customerRepo;

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
}
