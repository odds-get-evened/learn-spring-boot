package org.odds.learn.mentor_demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// owning side
@Entity
@Table(name = "albums")
public class AlbumEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(name = "release_date")
	private Long releaseDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "album_id", referencedColumnName = "id")
	Set<SongEntity> songs = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "album_artists", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private Set<ArtistEntity> artists = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Long releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set<SongEntity> getSongs() {
		return songs;
	}

	public void setSongs(Set<SongEntity> songs) {
		this.songs = songs;
	}

	public Set<ArtistEntity> getArtists() {
		return artists;
	}

	public void setArtists(Set<ArtistEntity> artists) {
		this.artists = artists;
	}

	public void addArtist(ArtistEntity a) {
		this.artists.add(a);
	}
}
