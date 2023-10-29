package com.challengersx.portfolioflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challengersx.portfolioflex.entities.UserProfile;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
