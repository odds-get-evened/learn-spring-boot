package org.odds.learn.mentor_demo.repo.dot;

import org.odds.learn.mentor_demo.entity.dot.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryEntity, Long> {}
