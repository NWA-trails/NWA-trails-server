package com.teamtwo.trails.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findByUsername(String username);
    List<UserModel> findAll();

    @Query(value = "Select USER.username, USER.first_name, USER.last_name, USER.email, USER.role, ACCOUNT.dateofbirth, ACCOUNT.height, ACCOUNT.weight FROM users as USER LEFT JOIN account_information as ACCOUNT ON USER.username = ACCOUNT.username WHERE USER.username = :username", nativeQuery = true)
    public UserDetailsDTO getUserDetails(@Param("username") String username);
}
