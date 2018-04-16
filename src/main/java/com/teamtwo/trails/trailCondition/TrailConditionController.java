package com.teamtwo.trails.trailCondition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RestController
@RequestMapping("/trailcondition")
public class TrailConditionController {

    @Autowired
    TrailConditionService trailConditionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"Trail Condition Service\"}";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionModel>> getAll() {
        return new ResponseEntity<>(trailConditionService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/getActive", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionNoImage>> getActive() {
        return new ResponseEntity<>(trailConditionService.getByActive(true),HttpStatus.OK);
    }

    @RequestMapping(value = "/getInactive", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionNoImage>> getInactive() {
        return new ResponseEntity<>(trailConditionService.getByActive(false),HttpStatus.OK);
    }

    @RequestMapping(value = "/getAcknowledged", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionNoImage>> getAcknowledged() {
        return new ResponseEntity<>(trailConditionService.getByAcknowledged(true),HttpStatus.OK);
    }

    @RequestMapping(value = "/getUnacknowledged", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionNoImage>> getUnacknowledged() {
        return new ResponseEntity<>(trailConditionService.getByAcknowledged(false),HttpStatus.OK);
    }

    @RequestMapping(value = "/getImageById/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionImage>> getImageById(@PathVariable long id) {
        return new ResponseEntity<>(trailConditionService.getImageById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/markInactiveById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markInactiveById(@PathVariable long id) {
        trailConditionService.markInactiveById(id);
        return new ResponseEntity<>("{\"message\":\"Marked condition as inactive for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/markActiveById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markActiveById(@PathVariable long id) {
        trailConditionService.markActiveById(id);
        return new ResponseEntity<>("{\"message\":\"Marked condition as active for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/markAcknowledgedById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markAcknowledgedById(@PathVariable long id) {
        trailConditionService.markAcknowledgedById(id);
        return new ResponseEntity<>("{\"message\":\"Marked condition as acknowledged for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/markUnacknowledgedById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> markUnacknowledgedById(@PathVariable long id) {
        trailConditionService.markUnacknowledgedById(id);
        return new ResponseEntity<>("{\"message\":\"Marked condition as unacknowledged for id: "+ id +"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionModel>> findByUsername( @RequestParam String username) {
        return new ResponseEntity<>(trailConditionService.findByUsername(username.toUpperCase()),HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<String> add( @RequestBody TrailConditionModel TrailConditionModel ) {
        trailConditionService.add(TrailConditionModel);
        return new ResponseEntity<>("{\"id\":\""+String.valueOf(TrailConditionModel.getId())+"\"}\"", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public ResponseEntity<String> delete( @RequestBody TrailConditionModel TrailConditionModel ) {
        trailConditionService.delete(TrailConditionModel);
        return new ResponseEntity<>("{\"message\":\"Submitted trail condition: "+TrailConditionModel.getDescription() +" successfully.\"}", HttpStatus.OK);
    }

}
