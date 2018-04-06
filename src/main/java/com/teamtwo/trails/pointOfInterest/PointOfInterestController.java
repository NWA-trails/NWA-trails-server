package com.teamtwo.trails.pointOfInterest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trailcondition")
public class PointOfInterestController {

    @Autowired
    PointOfInterestService pointOfInterestService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"Point of Interest Service\"}";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestModel>> getAll() {
        return new ResponseEntity<>(pointOfInterestService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestModel>> findByUsername( @RequestParam String username) {
        return new ResponseEntity<>(pointOfInterestService.findByUsername(username.toUpperCase()),HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<Long> add( @RequestBody PointOfInterestModel PointOfInterestModel ) {
        pointOfInterestService.add(PointOfInterestModel);
        return new ResponseEntity<>(PointOfInterestModel.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public ResponseEntity<String> delete( @RequestBody PointOfInterestModel PointOfInterestModel ) {
        pointOfInterestService.delete(PointOfInterestModel);
        return new ResponseEntity<>("{\"message\":\"Submitted point of interest: "+PointOfInterestModel.getDescription() +" successfully.\"}", HttpStatus.OK);
    }

}