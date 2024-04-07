package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import swe6813team2.matchmakr.models.Profile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProfileRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    void testSaveProfile() {
        // Create a new profile
        Profile profile = new Profile();

        // Save the profile to the repository
        Profile savedProfile = profileRepository.save(profile);

        // Verify that the profile is saved with an ID
        assertTrue(savedProfile.getUserID() > 0);

        // Retrieve the profile from the repository
        Profile retrievedProfile = entityManager.find(Profile.class, savedProfile.getUserID());

        // Verify that the retrieved profile matches the saved profile
        assertEquals(savedProfile, retrievedProfile);
    }

    @Test
    void testFindAllProfiles() {
        // Create some test profiles
        Profile profile1 = new Profile();

        Profile profile2 = new Profile();

        // Save the profiles to the repository
        entityManager.persist(profile1);
        entityManager.persist(profile2);

        // Retrieve all profiles from the repository
        List<Profile> profiles = profileRepository.findAll();

        // Verify that the correct number of profiles are retrieved
        assertEquals(2, profiles.size());

        // Verify that the retrieved profiles match the saved profiles
        assertTrue(profiles.contains(profile1));
        assertTrue(profiles.contains(profile2));
    }
}
