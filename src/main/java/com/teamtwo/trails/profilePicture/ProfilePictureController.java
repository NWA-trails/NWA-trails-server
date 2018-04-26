package com.teamtwo.trails.profilePicture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profilepicture")
public class ProfilePictureController {

    @Autowired
    ProfilePictureService profilePictureService;

    @RequestMapping(value = "/getProfilePicture/{username}", method = RequestMethod.GET)
    public ResponseEntity<String> getByUsername(@PathVariable String username) {
        return new ResponseEntity<>(profilePictureService.getByUsername(username), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody ProfilePictureDTO profilePictureDTO) {
        if (profilePictureService.update(profilePictureDTO))
            return new ResponseEntity<>("{\"message\":\"Updated profile picture.\"}", HttpStatus.OK);
        else
            return new ResponseEntity<>("{\"message\":\"Failed to update profile picture.\"}", HttpStatus.OK);
    }

}
