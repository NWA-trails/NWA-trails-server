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

    public boolean update(ProfilePictureModel profilePictureModel) {
        System.out.println("Model username: " + profilePictureModel.getUsername() + " image: " + profilePictureModel.getImage());
        ProfilePictureModel oldProfilePictureModels = profilePictureRepository.findByUsername(profilePictureModel.getUsername());
        ProfilePictureModel profilePicture;
        try {
            if (oldProfilePictureModels != null) {
                profilePicture = oldProfilePictureModels;
                profilePicture.setImage(profilePictureModel.getImage());
                profilePictureRepository.save(profilePicture);
            } else {
                profilePictureRepository.save(profilePictureModel);
            }
        } catch(RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

        return true;
    }
}
