package com.teamtwo.trails.profilePicture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfilePictureRepository extends CrudRepository<ProfilePictureModel, Long>{
    List<ProfilePictureModel> findByUsername(String username);
}
