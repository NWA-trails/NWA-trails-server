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

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final PasswordEncoder passwordEncoder;

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService,
                          TokenProvider tokenProvider,
                          AuthenticationManager authenticationManager,
                          PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
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
        System.out.println("Logging in user: " + userModel.getUsername() + " with password: " + userModel.getPassword());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userModel.getUsername().toUpperCase(), passwordEncoder.encode(userModel.getPassword()));

        try {
            this.authenticationManager.authenticate(authenticationToken);
            System.out.println("Successfully logged in user: " + userModel.getUsername());
            return new ResponseEntity<>(this.tokenProvider.createToken(userModel.getUsername()), HttpStatus.OK);
        } catch (AuthenticationException e) {
            System.out.println("Failed to login in user with error: " + e.getMessage());
            return new ResponseEntity<>("{\"message\":\"Username or Password is invalid\"}", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "{\"text\":\"Hello World!\"}";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public ResponseEntity<String> register( @RequestBody UserModel userModel ) {
        userService.register(userModel);
        return new ResponseEntity<>("{\"message\":\"Created user "+userModel.getUsername()+" successfully.\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/validate", method= RequestMethod.POST)
    public ResponseEntity<String> validate(@RequestBody UserModel userModel ) {
        if (userService.isPassword(userModel.getPassword(), userModel.getUsername())) {
            return new ResponseEntity<>("{\"message\":\"Login successful.\"}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{\"message\":\"Login failed.\"}", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/getUserDetails/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserDetails(username.toUpperCase()), HttpStatus.OK);
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
