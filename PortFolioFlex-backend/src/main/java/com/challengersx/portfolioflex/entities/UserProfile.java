package com.challengersx.portfolioflex.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String contactNumber;
	private String profilePhoto;
	private String videoProfileLink; // Add a < 3min video that covers: i. Who are you ? ii. Professional achievements till now ? iii. What do you like to work on

	@Enumerated(EnumType.STRING)
	private UserType userType; // Developer, Designer, Content Specialist, Product Manager

	@Enumerated(EnumType.STRING)
	private JobType jobType; // Part Time, Full Time, Gigs, Internships
	
	@OneToMany(mappedBy = "userProfile", cascade = CascadeType.MERGE)
	@JsonManagedReference
//	private List<Portfolio> portfolios;
	private List<ExternalProfile> externalProfiles;

	@OneToMany(mappedBy = "userProfile", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private List<Project> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getVideoProfileLink() {
		return videoProfileLink;
	}

	public void setVideoProfileLink(String videoProfileLink) {
		this.videoProfileLink = videoProfileLink;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public List<ExternalProfile> getExternalProfiles() {
		return externalProfiles;
	}

	public void setExternalProfiles(List<ExternalProfile> externalProfiles) {
		this.externalProfiles = externalProfiles;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
}
