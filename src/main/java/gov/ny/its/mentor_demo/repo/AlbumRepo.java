package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<AlbumEntity, Long> {}
