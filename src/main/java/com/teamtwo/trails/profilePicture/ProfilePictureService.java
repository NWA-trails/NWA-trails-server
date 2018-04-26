package com.teamtwo.trails.profilePicture;

import com.teamtwo.trails.wrapper.ProfilePictureStringWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class ProfilePictureService {

    @Autowired
    ProfilePictureRepository profilePictureRepository;

    public String getByUsername(String username) {
        ProfilePictureModel profilePicture = profilePictureRepository.findByUsername(username);

        if (profilePicture != null) {
            String image = new String(Base64.getDecoder().decode(profilePicture.getImage()));
            return new String("{\"image\": \"" + image + "\"}");
        } else {
            return "{\"image\": \"\"}";
        }
    }

    public boolean update(ProfilePictureStringWrapper wrapper) {
        System.out.println("Model username: " + wrapper.getUsername() + " image: " + wrapper.getImage());
        ProfilePictureModel oldProfilePictureModels = profilePictureRepository.findByUsername(wrapper.getUsername());
        ProfilePictureModel profilePicture;
        try {
            if (oldProfilePictureModels != null) {
                profilePicture = oldProfilePictureModels;
                profilePicture.setImage(wrapper.getImage().getBytes());
                profilePictureRepository.save(profilePicture);
            } else {
                profilePicture = new ProfilePictureModel();
                profilePicture.setUsername(wrapper.getUsername());
                profilePicture.setImage(wrapper.getImage().getBytes());

                profilePictureRepository.save(profilePicture);
            }
        } catch(RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

        return true;
    }
}
