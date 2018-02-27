package com.teamtwo.trails.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void register(UserModel userModel) {
        System.out.println("userModel:model:___________"+userModel);
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        System.out.println("password:model:___________"+userModel.getPassword());
        userRepository.save(userModel);
    }

}
