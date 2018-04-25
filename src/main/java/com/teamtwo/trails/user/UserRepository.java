package com.teamtwo.trails.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    String userDetailsQuery = "Select " +
            "USERINFO.username, " +
            "USERINFO.first_name, " +
            "USERINFO.last_name, " +
            "USERINFO.email, " +
            "USERINFO.role, " +
            "ACCOUNT.dateofbirth, " +
            "ACCOUNT.height, " +
            "ACCOUNT.weight " +
            "FROM \"user\" as USERINFO " +
            "INNER JOIN account_information as ACCOUNT " +
            "ON USERINFO.username = ACCOUNT.username " +
            "WHERE USERINFO.username = :username";

    List<UserModel> findByUsername(String username);
    List<UserModel> findAll();

    @Query(userDetailsQuery)
    public UserDetailsDTO getUserDetails(@Param("username") String username);
}
