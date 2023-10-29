package com.challengersx.portfolioflex.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private List<ProjectImage> projectImages;

//	@ManyToOne
//	@JoinColumn(name = "portfolio_id")
//	private Portfolio portfolio;

	@ManyToOne
	@JoinColumn(name = "user_profile_id")
	@JsonBackReference
	private UserProfile userProfile;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProjectImage> getProjectImages() {
		return projectImages;
	}

	public void setProjectImages(List<ProjectImage> projectImages) {
		this.projectImages = projectImages;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}
