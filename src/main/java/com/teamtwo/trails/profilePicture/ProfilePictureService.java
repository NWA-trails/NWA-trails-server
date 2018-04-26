package com.teamtwo.trails.profilePicture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilePictureService {

    @Autowired
    ProfilePictureRepository profilePictureRepository;

    public String getByUsername(String username) {
        return new String(profilePictureRepository.findByUsername(username).get(0).getImage());
    }

    public boolean update(ProfilePictureModel profilePictureModel) {
        List<ProfilePictureModel> oldProfilePictureModels = profilePictureRepository.findByUsername(profilePictureModel.getUsername());
        ProfilePictureModel profilePicture;
        try {
            if (oldProfilePictureModels.get(0) != null) {
                profilePicture = oldProfilePictureModels.get(0);
                profilePicture.setImage(profilePictureModel.getImage());
                profilePictureRepository.save(profilePicture);
            } else {
                profilePictureRepository.save(profilePictureModel);
            }
        } catch(RuntimeException e) {
            return false;
        }

        return true;
    }
}
