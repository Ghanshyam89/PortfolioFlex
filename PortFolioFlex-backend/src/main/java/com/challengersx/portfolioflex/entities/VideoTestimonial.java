package com.challengersx.portfolioflex.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VideoTestimonial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String videoLink;

	@ManyToOne
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;

	// Getters and setters
}
