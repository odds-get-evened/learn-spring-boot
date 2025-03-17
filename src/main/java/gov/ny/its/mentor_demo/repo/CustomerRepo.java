package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {}
