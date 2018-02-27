package com.teamtwo.trails.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void register(UserModel userModel) {
        System.out.println("userModel: _________________" + userModel);
        userRepository.save(userModel);
    }

}
