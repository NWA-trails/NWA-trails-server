package com.teamtwo.trails.Security;

import com.teamtwo.trails.user.UserModel;
import com.teamtwo.trails.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public AppUserDetailsService(UserService userService) {
                this.userService = userService;
    }

    @Override
    public final UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In userDetailService looking up the user");
        final UserModel user = this.userService.lookup(username);

                if (user == null) {
                System.out.println("Did not find username: " + username);
                throw new UsernameNotFoundException("User '" + username + "' not found.");
            }

                System.out.println("Found user: " + username + " with password: " + user.getPassword());

                return User.withUsername(username)
                        .password(user.getPassword())
                        .authorities(Collections.emptyList())
                        .accountExpired(false)
                        .accountLocked(false)
                        .credentialsExpired(false)
                        .disabled(false)
                        .build();
    }
}