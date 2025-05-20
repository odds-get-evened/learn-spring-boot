package org.odds.learn.mentor_demo.entity;

import jakarta.persistence.*;
import org.hibernate.Length;

@Entity
@Table(name = "songs")
public class SongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(columnDefinition = "LONGTEXT", length = Length.LONG32)
	private String lyrics;

	@ManyToOne
	@JoinColumn(name = "album_id", referencedColumnName = "id")
	private AlbumEntity album;

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
}
