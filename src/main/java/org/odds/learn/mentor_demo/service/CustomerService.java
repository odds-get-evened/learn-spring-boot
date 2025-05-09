package org.odds.learn.mentor_demo.service;

import jakarta.persistence.EntityNotFoundException;
import org.odds.learn.mentor_demo.entity.CustomerEntity;
import org.odds.learn.mentor_demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public CustomerEntity getById(Long id) {
		return customerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("customer not found"));
	}
}
