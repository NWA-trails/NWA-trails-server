package com.teamtwo.trails.emergencyContact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emergencycontact")
public class EmergencyContactController {

    @Autowired
    EmergencyContactService emergencyContactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"E-contacts\"}";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<EmergencyContactModel>> getAll() {
        return new ResponseEntity<>(emergencyContactService.getAll(),HttpStatus.OK);
    }

        //todo
//    @RequestMapping(value = "/add", method= RequestMethod.POST)
//    public ResponseEntity<String> register( @RequestBody EmergencyContactModel emergencyContactModel ) {
//        //todo
//    }

}
