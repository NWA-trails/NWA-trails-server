package com.teamtwo.trails.profilePicture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilePictureService {

    @Autowired
    ProfilePictureRepository profilePictureRepository;

    public String getByUsername(String username) {
        return new String(profilePictureRepository.findByUsername(username).getImage());
    }

    public boolean update(ProfilePictureDTO profilePictureDTO) {
        System.out.println("Model username: " + profilePictureDTO.getUsername() + " image: " + profilePictureDTO.getImage());
        ProfilePictureModel oldProfilePictureModels = profilePictureRepository.findByUsername(profilePictureDTO.getUsername());
        ProfilePictureModel profilePicture;
        try {
            if (oldProfilePictureModels != null) {
                profilePicture = oldProfilePictureModels;
                profilePicture.setImage(profilePictureDTO.getImage().getBytes());
                profilePictureRepository.save(profilePicture);
            } else {
                profilePicture = new ProfilePictureModel();
                profilePicture.setUsername(profilePictureDTO.getUsername());
                profilePicture.setImage(profilePictureDTO.getImage().getBytes());

                profilePictureRepository.save(profilePicture);
            }
        } catch(RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

        return true;
    }
}
