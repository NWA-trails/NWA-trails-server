package com.teamtwo.trails.trailCondition;


import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "trail_condition")
public class TrailConditionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @Column(name = "image")
    private Byte[] image;

    @Column(name = "description")
    private String description;

    public TrailConditionModel() {
    }

    public TrailConditionModel(long id, String username, ZonedDateTime timestamp, Byte[] image, String description) {
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;
        this.image = image;
        this.description = description;
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

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
