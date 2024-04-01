package swe6813team2.matchmakr.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import swe6813team2.matchmakr.models.Profile;
import swe6813team2.matchmakr.repositories.ProfileRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileController profileController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    @Test
    public void testGetAllProfiles() throws Exception {
        // Arrange
        Profile profile1 = new Profile();
        profile1.setUserID(1L);
        Profile profile2 = new Profile();
        profile2.setUserID(2L);
        List<Profile> profiles = Arrays.asList(profile1, profile2);

        when(profileRepository.findAll()).thenReturn(profiles);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/profiles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userID").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userID").value(2L));
    }
}