package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import swe6813team2.matchmakr.models.Profile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class ProfileRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testSaveProfile() {
        // Create a new profile
        Profile profile = new Profile();
        profile.setName("Test Profile");
        profile.setDescription("This is a test profile");

        // Save the profile to the repository
        Profile savedProfile = profileRepository.save(profile);

        // Verify that the profile is saved with an ID
        assertTrue(savedProfile.getId() > 0);

        // Retrieve the profile from the repository
        Profile retrievedProfile = entityManager.find(Profile.class, savedProfile.getId());

        // Verify that the retrieved profile matches the saved profile
        assertEquals(savedProfile, retrievedProfile);
    }

    @Test
    public void testFindAllProfiles() {
        // Create some test profiles
        Profile profile1 = new Profile();
        profile1.setName("Profile 1");
        profile1.setDescription("This is profile 1");

        Profile profile2 = new Profile();
        profile2.setName("Profile 2");
        profile2.setDescription("This is profile 2");

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