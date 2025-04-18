package org.odds.learn.mentor_demo.service;

import org.odds.learn.mentor_demo.entity.AlbumEntity;
import org.odds.learn.mentor_demo.entity.ArtistEntity;
import org.odds.learn.mentor_demo.repo.AlbumRepo;
import org.odds.learn.mentor_demo.repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepo albumRepo;

	@Autowired
	private ArtistRepo artistRepo;

	public void addArtistToAlbum(Long albumId, Long artistId) {
		AlbumEntity album = albumRepo.findById(albumId).orElseThrow();
		ArtistEntity artist = artistRepo.findById(artistId).orElseThrow();

		album.addArtist(artist);
	}
}
