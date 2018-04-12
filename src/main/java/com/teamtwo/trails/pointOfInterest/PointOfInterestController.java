package com.teamtwo.trails.pointOfInterest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pointofinterest")
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

    @RequestMapping(value = "/getActive", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestNoImage>> getActive() {
        return new ResponseEntity<>(pointOfInterestService.getByActive(true),HttpStatus.OK);
    }

    @RequestMapping(value = "/getInactive", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestNoImage>> getInactive() {
        return new ResponseEntity<>(pointOfInterestService.getByActive(false),HttpStatus.OK);
    }

    @RequestMapping(value = "/getApproved", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestNoImage>> getApproved() {
        return new ResponseEntity<>(pointOfInterestService.getByApproved(true),HttpStatus.OK);
    }

    @RequestMapping(value = "/getUnapproved", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestNoImage>> getUnapproved() {
        return new ResponseEntity<>(pointOfInterestService.getByApproved(false),HttpStatus.OK);
    }

    @RequestMapping(value = "/getImageById/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestImage>> getImageById(@PathVariable long id) {
        return new ResponseEntity<>(pointOfInterestService.getImageById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/markInactiveById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markInactiveById(@PathVariable long id) {
        pointOfInterestService.markInactiveById(id);
        return new ResponseEntity<>("{\"message\":\"Marked point of interest as inactive for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/markActiveById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markActiveById(@PathVariable long id) {
        pointOfInterestService.markActiveById(id);
        return new ResponseEntity<>("{\"message\":\"Marked point of interest as active for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/markApproved/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markApprovedById(@PathVariable long id) {
        pointOfInterestService.markApprovedById(id);
        return new ResponseEntity<>("{\"message\":\"Marked point of interest as approved for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/markApproved/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markUnapprovedById(@PathVariable long id) {
        pointOfInterestService.markUnapprovedById(id);
        return new ResponseEntity<>("{\"message\":\"Marked point of interest as unapproved for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
    public ResponseEntity<List<PointOfInterestModel>> findByUsername( @RequestParam String username) {
        return new ResponseEntity<>(pointOfInterestService.findByUsername(username.toUpperCase()),HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<String> add( @RequestBody PointOfInterestModel PointOfInterestModel ) {
        pointOfInterestService.add(PointOfInterestModel);
        return new ResponseEntity<>("{\"id\":\""+String.valueOf(PointOfInterestModel.getId())+"\"}\"", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public ResponseEntity<String> delete( @RequestBody PointOfInterestModel PointOfInterestModel ) {
        pointOfInterestService.delete(PointOfInterestModel);
        return new ResponseEntity<>("{\"message\":\"Submitted point of interest: "+PointOfInterestModel.getDescription() +" successfully.\"}", HttpStatus.OK);
    }

}