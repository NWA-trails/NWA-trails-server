package com.teamtwo.trails.user;

import com.teamtwo.trails.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

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

    public UserDetailsDTO getUserDetails(String username) {
        Object[] results = userRepository.getUserDetails(username).get(0);

        UserDetailsDTO userDetails = new UserDetailsDTO();
        if (results.length > 0) {
            userDetails.setUsername((String) results[0]);
            userDetails.setFirst_name((String) results[1]);
            userDetails.setLast_name((String) results[2]);
            userDetails.setEmail((String) results[3]);
            userDetails.setRole((String) results[4]);
            userDetails.setDateofbirth((String) results[5]);
            userDetails.setHeight((String) results[6]);
            userDetails.setWeight((String) results[7]);
        }

        return userDetails;
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

    public void delete(long id) {
        userRepository.delete(id);
    }

    public void makeAdminById(long id) {
        UserModel userModel = userRepository.getOne(id);
        userModel.setRole(Constants.ROLE_ADMIN);
        userRepository.save(userModel);
    }

    public void revokeAdminById(long id) {
        UserModel userModel = userRepository.getOne(id);
        userModel.setRole(Constants.ROLE_LIMITED);
        userRepository.save(userModel);
    }

}
