package org.odds.learn.mentor_demo.repo;

import org.odds.learn.mentor_demo.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlbumRepo extends JpaRepository<AlbumEntity, Long> {
	@Query("SELECT a FROM AlbumEntity a LEFT JOIN a.songs b WHERE b.lyrics IS NOT NULL")
	List<AlbumEntity> albumsWithLyrics();
}
