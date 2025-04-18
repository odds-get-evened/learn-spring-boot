package org.odds.learn.mentor_demo.repo;

import org.odds.learn.mentor_demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {}
