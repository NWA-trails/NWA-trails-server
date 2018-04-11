package com.teamtwo.trails.trailCondition;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trail_condition")
public class TrailConditionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "image")
    private Byte[] image;

    @Column(name = "description")
    private String description;

    @Column(name = "lat")
    private float lat;

    @Column(name = "lng")
    private float lng;

    @Column(name = "active")
    private boolean active;

    @Column(name = "acknowledged")
    private boolean acknowledged;

    public TrailConditionModel(long id, String username, Timestamp timestamp, Byte[] image, String description, float lat, float lng, boolean active, boolean acknowledged) {
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;
        this.image = image;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.active = active;
        this.acknowledged = acknowledged;
    }

    public TrailConditionModel() {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
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

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }
}
