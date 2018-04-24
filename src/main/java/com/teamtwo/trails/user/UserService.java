package com.teamtwo.trails.user;

import com.teamtwo.trails.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    public void register(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setUsername(userModel.getUsername().toUpperCase());
        userModel.setRole(Constants.ROLE_LIMITED);
        userRepository.save(userModel);
    }

    public UserModel getUserInformation(String username) {
        username = username.toUpperCase();
        UserModel userModel = userRepository.findByUsername(username).get(0);
        userModel.setPassword("");
        return userModel;
    }

    public boolean isPassword(String password, String username) {
        username = username.toUpperCase();
        UserModel userModel = userRepository.findByUsername(username).get(0);
        return passwordEncoder.matches(password, userModel.getPassword());
    }

    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        UserModel userModel = userRepository.findByUsername(username).get(0);
        if (passwordEncoder.matches(oldPassword, userModel.getPassword())) {
            userModel.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(userModel);
            return true;
        } else {
            return false;
        }
    }


}
