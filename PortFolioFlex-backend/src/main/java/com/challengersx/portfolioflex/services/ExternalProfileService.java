package com.challengersx.portfolioflex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengersx.portfolioflex.entities.ExternalProfile;
import com.challengersx.portfolioflex.repository.ExternalProfileRepository;

@Service
public class ExternalProfileService {
	@Autowired
	private ExternalProfileRepository externalProfileRepository;

	public ExternalProfile createExternalProfile(ExternalProfile externalProfile) {
		return externalProfileRepository.save(externalProfile);
	}

	public ExternalProfile getExternalProfile(Long id) {
		return externalProfileRepository.findById(id).orElse(null);
	}

	public ExternalProfile updateExternalProfile(Long id, ExternalProfile externalProfile) {
		if (externalProfileRepository.existsById(id)) {
			externalProfile.setId(id);
			return externalProfileRepository.save(externalProfile);
		}
		return null; // Not found
	}

	public boolean deleteExternalProfile(Long id) {
		if (externalProfileRepository.existsById(id)) {
			externalProfileRepository.deleteById(id);
			return true;
		}
		return false; // Not found
	}
}
