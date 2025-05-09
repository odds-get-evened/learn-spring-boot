package org.odds.learn.mentor_demo.entity;

import jakarta.persistence.*;
import org.hibernate.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "songs")
public class SongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(columnDefinition = "LONGTEXT", length = Length.LONG32)
	private String lyrics;

	@Column(name = "album_id")
	private Long albumId;

	@ManyToMany(mappedBy = "favoriteSongs")
	private Set<CustomerEntity> fans = new HashSet<>();

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

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public Set<CustomerEntity> getFans() {
		return fans;
	}

	public void setFans(Set<CustomerEntity> fans) {
		this.fans = fans;
	}
}
