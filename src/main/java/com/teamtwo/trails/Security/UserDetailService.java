package com.teamtwo.trails.Security;

import com.teamtwo.trails.user.UserModel;
import com.teamtwo.trails.user.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {
    private UserService userService;

    public UserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public final UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserModel user = this.userService.lookup(username);


        if (user == null) {
            System.out.println("In loadUserByUsername, user was null, throwing exception");
            throw new UsernameNotFoundException("User '" + username.toUpperCase() + "' was not found.");
        }

        System.out.println("In loadUserByUsername, user retrieved: " + user.getUsername());

        return User
                .withUsername(username.toUpperCase())
                .password(user.getPassword())
                .authorities(user.getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
