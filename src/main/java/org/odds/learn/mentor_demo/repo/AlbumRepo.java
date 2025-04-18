package org.odds.learn.mentor_demo.repo;

import org.odds.learn.mentor_demo.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<AlbumEntity, Long> {}
