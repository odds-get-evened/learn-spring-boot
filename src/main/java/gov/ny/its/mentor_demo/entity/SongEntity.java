package gov.ny.its.mentor_demo.entity;

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

	@Column(name = "album_id")
	private Long albumId;

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
}
