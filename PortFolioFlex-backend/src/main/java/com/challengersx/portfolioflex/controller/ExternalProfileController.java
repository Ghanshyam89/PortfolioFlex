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
import com.challengersx.portfolioflex.services.ExternalProfileService;

@RestController
@RequestMapping("/api/external-profiles")
public class ExternalProfileController {
	@Autowired
	private ExternalProfileService externalProfileService;

	@PostMapping
	public ResponseEntity<ExternalProfile> createExternalProfile(@RequestBody ExternalProfile externalProfile) {
		ExternalProfile createdProfile = externalProfileService.createExternalProfile(externalProfile);
		return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ExternalProfile> getExternalProfile(@PathVariable Long id) {
		ExternalProfile externalProfile = externalProfileService.getExternalProfile(id);
		if (externalProfile != null) {
			return new ResponseEntity<>(externalProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExternalProfile> updateExternalProfile(@PathVariable Long id,
			@RequestBody ExternalProfile externalProfile) {
		ExternalProfile updatedProfile = externalProfileService.updateExternalProfile(id, externalProfile);
		if (updatedProfile != null) {
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExternalProfile(@PathVariable Long id) {
		if (externalProfileService.deleteExternalProfile(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
