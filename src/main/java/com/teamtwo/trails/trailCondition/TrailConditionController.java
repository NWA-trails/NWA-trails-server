package com.teamtwo.trails.trailCondition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(trailConditionService.getActive(true),HttpStatus.OK);
    }

    @RequestMapping(value = "/getImageById/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<TrailConditionImage>> getImageById(@PathVariable long id) {
        return new ResponseEntity<>(trailConditionService.getImageById(id),HttpStatus.OK);
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
