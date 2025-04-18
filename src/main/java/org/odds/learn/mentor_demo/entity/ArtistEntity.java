package org.odds.learn.mentor_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "artist_name")
	private String artistName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
}
