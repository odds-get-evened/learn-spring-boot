package org.odds.learn.mentor_demo.controller.dot;

import org.odds.learn.mentor_demo.entity.dot.InventoryEntity;
import org.odds.learn.mentor_demo.repo.dot.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dot/api/vehicle")
public class InventoryController {
	@Autowired
	private InventoryRepo invRepo;

	@GetMapping("/all")
	public List<InventoryEntity> getInventory() {
		return invRepo.findAll();
	}
}
