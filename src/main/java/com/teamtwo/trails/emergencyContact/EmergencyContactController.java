package com.teamtwo.trails.emergencyContact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencycontact")
public class EmergencyContactController {

    @Autowired
    EmergencyContactService emergencyContactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"Emergency Contact Service\"}";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<EmergencyContactModel>> getAll() {
        return new ResponseEntity<>(emergencyContactService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
    public ResponseEntity<List<EmergencyContactModel>> findByUsername( @RequestParam String username) {
        return new ResponseEntity<>(emergencyContactService.findByUsername(username.toUpperCase()),HttpStatus.OK);
    }


    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<Long> add( @RequestBody EmergencyContactModel emergencyContactModel ) {
        emergencyContactService.add(emergencyContactModel);
        return new ResponseEntity<>(emergencyContactModel.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public ResponseEntity<String> delete( @RequestBody EmergencyContactModel emergencyContactModel ) {
        emergencyContactService.delete(emergencyContactModel);
        return new ResponseEntity<>("{\"message\":\"Created emergency contact: "+emergencyContactModel.getContactName() +" successfully.\"}", HttpStatus.OK);
    }

}
