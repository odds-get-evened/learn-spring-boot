package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {}
