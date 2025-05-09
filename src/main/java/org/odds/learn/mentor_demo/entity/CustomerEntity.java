package org.odds.learn.mentor_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	@NotBlank(message = "first name cannot be blank")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	private String lastName;

	@NotBlank(message = "email is required")
	@Email(message = "not a valid email format")
	private String email;

	@Column(name = "phone_num")
	@Pattern(regexp = "\\(?\\d{3}\\)?[\\s\\-]\\d{3}\\-\\d{4}", message = "invalid phone number")
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "customer_favs", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
	private Set<SongEntity> favoriteSongs = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<SongEntity> getFavoriteSongs() {
		return favoriteSongs;
	}

	public void setFavoriteSongs(Set<SongEntity> favoriteSongs) {
		this.favoriteSongs = favoriteSongs;
	}
}
