package com.teamtwo.trails.profilePicture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profilepicture")
public class ProfilePictureController {

    @Autowired
    ProfilePictureService profilePictureService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody ProfilePictureModel profilePictureModel) {
        profilePictureService.add(profilePictureModel);
        return new ResponseEntity<>("{\"message\":\"Created profile picture.\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
    public ResponseEntity<List<ProfilePictureModel>> getByUsername(String username) {
        return new ResponseEntity<>(profilePictureService.getByUsername(username), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody ProfilePictureModel profilePictureModel) {
        if (profilePictureService.update(profilePictureModel))
            return new ResponseEntity<>("{\"message\":\"Updated profile picture.\"}", HttpStatus.OK);
        else
            return new ResponseEntity<>("{\"message\":\"Failed to update profile picture.\"}", HttpStatus.OK);
    }

}
