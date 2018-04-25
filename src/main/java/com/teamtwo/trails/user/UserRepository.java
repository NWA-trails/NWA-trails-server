package com.teamtwo.trails.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findByUsername(String username);
    List<UserModel> findAll();

    @Modifying
    @Query("Select USER.username, USER.first_name, USER.last_name, USER.email, USER.role, ACCOUNT.dateofbirth, ACCOUNT.height, ACCOUNT.weight FROM UserModel as USER LEFT JOIN USER.account_information as ACCOUNT ON USER.username = ACCOUNT.username WHERE USER.username = :username")
    public UserDetailsDTO getUserDetails(@Param("username") String username);
}
