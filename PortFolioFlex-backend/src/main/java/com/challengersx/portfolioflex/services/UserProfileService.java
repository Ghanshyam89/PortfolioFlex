package com.challengersx.portfolioflex.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengersx.portfolioflex.entities.ExternalProfile;
import com.challengersx.portfolioflex.entities.JobType;
import com.challengersx.portfolioflex.entities.Project;
import com.challengersx.portfolioflex.entities.UserProfile;
import com.challengersx.portfolioflex.entities.UserType;
import com.challengersx.portfolioflex.repository.UserProfileRepository;

@Service
public class UserProfileService {
	@Autowired
	private UserProfileRepository userProfileRepository;

	public UserProfile createUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	public UserProfile getUserProfile(Long id) {
		return userProfileRepository.findById(id).orElse(null);
	}

	public UserProfile updateUserProfile(Long id, UserProfile userProfile) {
		if (userProfileRepository.existsById(id)) {
			userProfile.setId(id);
			return userProfileRepository.save(userProfile);
		}
		return null; // Not found
	}

	public boolean deleteUserProfile(Long id) {
		if (userProfileRepository.existsById(id)) {
			userProfileRepository.deleteById(id);
			return true;
		}
		return false; // Not found
	}
	
	public UserProfile updateUserType(Long id, UserProfile userProfile){

		UserProfile updatedUserProfile = getUserProfile(id);
		if (updatedUserProfile != null) {
			updatedUserProfile.setUserType(userProfile.getUserType());
			return userProfileRepository.save(updatedUserProfile);
		}
		return null; // User not found
    }
	
	public UserProfile updateJobType(Long id, UserProfile userProfile){

		UserProfile updatedUserProfile = getUserProfile(id);
		if (updatedUserProfile != null) {
			updatedUserProfile.setJobType(userProfile.getJobType());
			return userProfileRepository.save(updatedUserProfile);
		}
		return null; // User not found
    }

	public UserProfile addExternalProfile(Long id, ExternalProfile externalProfile) {
		UserProfile userProfile = getUserProfile(id);
		if (userProfile != null) {
			externalProfile.setUserProfile(userProfile);
			userProfile.getExternalProfiles().add(externalProfile);
			return userProfileRepository.save(userProfile);
		}
		return null; // User not found
	}

	public UserProfile addProject(Long id, Project project) {
		UserProfile userProfile = getUserProfile(id);
		if (userProfile != null) {
			project.setUserProfile(userProfile);
			userProfile.getProjects().add(project);
			return userProfileRepository.save(userProfile);
		}
		return null; // User not found
	}
	
	public UserProfile addVideoProfileLink(Long id, String videoProfileLink){
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);

        if (userProfileOptional.isPresent()) {
            UserProfile userProfile = userProfileOptional.get();
            userProfile.setVideoProfileLink(videoProfileLink);
            UserProfile updatedUserProfile = userProfileRepository.save(userProfile);
            return updatedUserProfile;
        } else {
            return null; // User not found
        }
    }

}
