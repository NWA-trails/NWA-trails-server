package com.teamtwo.trails.profilePicture;

import javax.persistence.*;

@Entity
@Table(name = "profile_picture")
public class ProfilePictureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "image")
    private byte[] image;

    public ProfilePictureModel(long id, String username, byte[] image) {
        this.id = id;
        this.username = username;
        this.image = image;
    }

    public ProfilePictureModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
