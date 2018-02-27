package com.teamtwo.trails.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"Hello World!\"}";
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public ResponseEntity<String> register( @RequestBody UserModel userModel ) {
        userService.register(userModel);
        return new ResponseEntity<>("{\"message\":\"Created user: \""+userModel.getUsername()+"\" successfully.\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/validate", method= RequestMethod.POST)
    public ResponseEntity<String> validate(@RequestBody UserModel userModel ) {
        if (userService.isPassword(userModel.getPassword(), userModel.getId())) {
            return new ResponseEntity<>("{\"message\":\"Logged in successfully.\"}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{\"message\":\"Logged in failed.\"}", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/test", method= RequestMethod.POST)
    public Object test( @RequestBody Object object ) {
        return object;
    }


}
