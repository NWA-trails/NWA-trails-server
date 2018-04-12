package com.teamtwo.trails.user;

import com.teamtwo.trails.Security.JWT.TokenProvider;
import com.teamtwo.trails.wrapper.UpdatePasswordWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService,
                          TokenProvider tokenProvider,
                          AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"Hello World!\"}";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public boolean authenticate() {
        /*
            This will be called at the startup of the app to check if the
            token is still valid. Will return true if still valid
         */

        return true;
    }


    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody UserModel userModel) {
        System.out.println("Logging in user: " + userModel.getUsername());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userModel.getUsername(), userModel.getPassword());

        try {
            this.authenticationManager.authenticate(authenticationToken);
            System.out.println("Successfully logged in user: " + userModel.getUsername());
            return new ResponseEntity<>(this.tokenProvider.createToken(userModel.getUsername()), HttpStatus.OK);
        } catch (AuthenticationException e) {
            System.out.println("Failed to login in user with error: " + e.getMessage());
            return new ResponseEntity<>("{\"message\":\"Username or Password is invalid\"}", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public ResponseEntity<String> signup( @RequestBody UserModel userModel ) {
        if (userService.usernameExists(userModel.getUsername()) == true) {
            return new ResponseEntity<>("{\"message\":\"Username already exists.\"}", HttpStatus.CONFLICT);
        } else {
            userService.register(userModel);
            return new ResponseEntity<>(this.tokenProvider.createToken(userModel.getUsername()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordWrapper updatePasswordWrapper) {
        if(userService.updatePassword(updatePasswordWrapper.getUsername(),updatePasswordWrapper.getOldPassword(),updatePasswordWrapper.getNewPassword())) {
            return new ResponseEntity<>("{\"message\":\"Updated password.\"}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{\"message\":\"Failed to update password.\"}", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity<String> updatePassword(@RequestBody String img) {
        return new ResponseEntity<>("{\"image\":\"" + img + "\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method= RequestMethod.POST)
    public Object test( @RequestBody Object object ) {
        return object;
    }


}
