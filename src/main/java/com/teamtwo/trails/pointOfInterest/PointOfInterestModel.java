package com.teamtwo.trails.pointOfInterest;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "point_of_interest")
public class PointOfInterestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "description")
    private String description;

    @Column(name = "lat")
    private float lat;

    @Column(name = "lng")
    private float lng;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "active")
    private boolean active;

    @Column(name = "trail")
    private String trail;

    public PointOfInterestModel(long id, String username, Timestamp timestamp, byte[] image, String description, float lat, float lng, boolean approved, boolean active, String trail) {
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;
        this.image = image;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.approved = approved;
        this.active = active;
        this.trail = trail;
    }

    public PointOfInterestModel() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }




}
