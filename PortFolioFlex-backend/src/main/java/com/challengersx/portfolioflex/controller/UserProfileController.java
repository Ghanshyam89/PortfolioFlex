package com.challengersx.portfolioflex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengersx.portfolioflex.entities.ExternalProfile;
import com.challengersx.portfolioflex.entities.JobType;
import com.challengersx.portfolioflex.entities.Project;
import com.challengersx.portfolioflex.entities.UserProfile;
import com.challengersx.portfolioflex.services.UserProfileService;

@RestController
@RequestMapping("/api/user-profiles")
public class UserProfileController {
	@Autowired
	private UserProfileService userProfileService;

	// End-point to create a new user profile
	@PostMapping
	public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
		UserProfile createdProfile = userProfileService.createUserProfile(userProfile);
		return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
	}

	// End-point to get user profile by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
		UserProfile userProfile = userProfileService.getUserProfile(id);
		if (userProfile != null) {
			return new ResponseEntity<>(userProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to update user profile
	@PutMapping("/{id}")
	public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
		UserProfile updatedProfile = userProfileService.updateUserProfile(id, userProfile);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to delete user profile by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
		if (userProfileService.deleteUserProfile(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to add external Links
	@PutMapping("/{id}/externallink")
	public ResponseEntity<UserProfile> addExternalProfileLink(@PathVariable Long id,
			@RequestBody ExternalProfile externalProfile) {
		UserProfile updatedProfile = userProfileService.addExternalProfile(id, externalProfile);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to add project
	@PutMapping("/{id}/project")
	public ResponseEntity<UserProfile> addProject(@PathVariable Long id, @RequestBody Project project) {
		UserProfile updatedProfile = userProfileService.addProject(id, project);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to add video Links
	@PutMapping("/{id}/video")
	public ResponseEntity<UserProfile> addProject(@PathVariable Long id, @RequestBody String videoLink) {
		UserProfile updatedProfile = userProfileService.addVideoProfileLink(id, videoLink);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to add Job type
	@PutMapping("/{id}/jobtype")
	public ResponseEntity<UserProfile> updateJobType(@PathVariable Long id, @RequestBody UserProfile userProfile) {
		UserProfile updatedProfile = userProfileService.updateJobType(id, userProfile);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// End-point to add Job type
	@PutMapping("/{id}/usertype")
	public ResponseEntity<UserProfile> updateUserType(@PathVariable Long id, @RequestBody UserProfile userProfile) {
		UserProfile updatedProfile = userProfileService.updateUserType(id, userProfile);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
