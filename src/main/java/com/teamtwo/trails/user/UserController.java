package com.teamtwo.trails.user;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String register( @RequestBody UserModel userModel ) {
        userService.register(userModel);
        return "{\"status\":\"Created successfully.\"}";
    }

    @RequestMapping(value = "/test", method= RequestMethod.POST)
    public Object test( @RequestBody Object object ) {
        return object;
    }


}
