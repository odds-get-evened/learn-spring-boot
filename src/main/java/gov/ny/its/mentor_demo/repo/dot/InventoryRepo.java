package gov.ny.its.mentor_demo.repo.dot;

import gov.ny.its.mentor_demo.entity.dot.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryEntity, Long> {}
