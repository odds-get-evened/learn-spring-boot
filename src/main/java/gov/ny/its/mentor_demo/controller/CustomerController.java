package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.entity.CustomerEntity;
import gov.ny.its.mentor_demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String procCustomer(@ModelAttribute("customer") CustomerEntity customer) {
		// save form data back to database
		customerRepo.save(customer);

		return "redirect:/store/customers";
	}
}
