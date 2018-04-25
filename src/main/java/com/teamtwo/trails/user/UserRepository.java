package com.teamtwo.trails.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findByUsername(String username);
    List<UserModel> findAll();

    @Query(value = "Select USERS.username, USERS.first_name, USERS.last_name, USERS.email, USERS.role, ACCOUNT.dateofbirth, ACCOUNT.height, ACCOUNT.weight FROM users as USERS LEFT JOIN account_information as ACCOUNT ON USERS.username = ACCOUNT.username WHERE USERS.username = :username", nativeQuery = true)
    public UserDetailsDTO getUserDetails(@Param("username") String username);
}
