package com.teamtwo.trails.profilePicture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilePictureService {

    @Autowired
    ProfilePictureRepository profilePictureRepository;

    public List<ProfilePictureModel> getByUsername(String username) {
        return profilePictureRepository.findByUsername(username);
    }

    public void add(ProfilePictureModel profilePictureModel) {
        profilePictureRepository.save(profilePictureModel);
    }

    public boolean update(ProfilePictureModel profilePictureModel) {
        List<ProfilePictureModel> oldProfilePictureModels = profilePictureRepository.findByUsername(profilePictureModel.getUsername());
        ProfilePictureModel profilePicture;
        if (oldProfilePictureModels.get(0) != null) {
            profilePicture = oldProfilePictureModels.get(0);
            profilePicture.setImage(profilePictureModel.getImage());
            profilePictureRepository.save(profilePicture);
            return true;
        } else {
            return false;
        }
    }
}
