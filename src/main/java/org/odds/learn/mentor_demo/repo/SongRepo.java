package org.odds.learn.mentor_demo.repo;

import org.odds.learn.mentor_demo.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<SongEntity, Long> {}
