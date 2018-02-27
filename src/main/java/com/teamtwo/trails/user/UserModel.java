package com.teamtwo.trails.user;

import javax.persistence.*;

@Entity
@Table(name = "usertest")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    protected UserModel() {
    }

    public UserModel(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return id + ":" + username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
