package com.teamtwo.trails.user;


import com.teamtwo.trails.Security.JWT.TokenProvider;
import com.teamtwo.trails.wrapper.UpdatePasswordWrapper;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public UserController(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authorize(@RequestBody UserModel user) {
        System.out.println("In user controller login, trying to authenticate user: " + user.getUsername().toUpperCase());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername().toUpperCase(), user.getPassword());

        try {
            this.authenticationManager.authenticate(authenticationToken);
            System.out.println("Successfully authenticated user: " + user.getUsername().toUpperCase());
            return this.tokenProvider.createToken(user.getUsername());
        } catch (AuthenticationException e) {
            System.out.println("Security Exception when trying to login user: " + user.getUsername().toUpperCase() + " with message: " + e);
            return null;
        }
    }

    /*
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

    */

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

    @RequestMapping(value = "/makeAdminById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> makeAdminById( @PathVariable long id ) {
        userService.makeAdminById(id);
        return new ResponseEntity<>("{\"message\":\"Made user an admin: "+id +" successfully.\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/revokeAdminById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> revokeAdminById( @PathVariable long id ) {
        userService.revokeAdminById(id);
        return new ResponseEntity<>("{\"message\":\"Revoked user as admin: "+id +" successfully.\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity<String> updatePassword(@RequestBody String img) {
        return new ResponseEntity<>("{\"image\":\"" + img + "\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method= RequestMethod.POST)
    public Object test( @RequestBody Object object ) {
        return object;
    }

    @RequestMapping(value = "/deleteById/{id}", method= RequestMethod.PUT)
    public ResponseEntity<String> deleteById( @PathVariable long id ) {
        userService.delete(id);
        return new ResponseEntity<>("{\"message\":\"Deleted user: "+id +" successfully.\"}", HttpStatus.OK);
    }

}
