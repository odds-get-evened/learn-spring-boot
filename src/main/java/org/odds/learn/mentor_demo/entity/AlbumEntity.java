package org.odds.learn.mentor_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "album_id", referencedColumnName = "id")
	List<SongEntity> songs = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "album_artists", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private List<ArtistEntity> artists = new ArrayList<>();

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

	public List<SongEntity> getSongs() {
		return songs;
	}

	public void setSongs(List<SongEntity> songs) {
		this.songs = songs;
	}

	public List<ArtistEntity> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistEntity> artists) {
		this.artists = artists;
	}

	public void addArtist(ArtistEntity a) {
		this.artists.add(a);
	}
}
