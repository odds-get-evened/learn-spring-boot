package org.odds.learn.mentor_demo.repo;

import org.odds.learn.mentor_demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {}
