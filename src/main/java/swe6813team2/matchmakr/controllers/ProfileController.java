package swe6813team2.matchmakr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swe6813team2.matchmakr.models.Profile;
import swe6813team2.matchmakr.repositories.ProfileRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}
}
