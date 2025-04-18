package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<ArtistEntity, Long> {
	// custom query to demo how to put use parameter placeholders for WHERE clause
	// @Query("SELECT * FROM album_artists AS b LEFT JOIN artists AS a ON (a.id = b.artist_id) WHERE b.album_id = :album_id")
	// List<ArtistEntity> findByAlbumId(@Param("album_id") Long id);
}
