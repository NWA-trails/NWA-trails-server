package com.teamtwo.trails.user;

import com.teamtwo.trails.Constants;
import org.hibernate.jpa.internal.EntityManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager em;

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
        List<UserDetailsDTO> userDetailsDTOS = this.em.createNativeQuery("Select USERS.username, USERS.first_name, USERS.last_name, USERS.email, USERS.role, ACCOUNT.dateofbirth, ACCOUNT.height, ACCOUNT.weight FROM users as USERS LEFT JOIN account_information as ACCOUNT ON USERS.username = ACCOUNT.username WHERE USERS.username = " + username, UserDetailsDTO.class).getResultList();
        UserDetailsDTO userDetails = userDetailsDTOS.get(0);
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


}
