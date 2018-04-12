package com.teamtwo.trails.pointOfInterest;

import java.sql.Timestamp;

public interface PointOfInterestNoImage {
    long getId();
    String getUsername();
    Timestamp getTimestamp();
    String getDescription();
    float getLat();
    float getLng();
    boolean getActive();
    boolean getApproved();
}
