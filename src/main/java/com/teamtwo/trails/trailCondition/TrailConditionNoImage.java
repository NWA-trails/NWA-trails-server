package com.teamtwo.trails.trailCondition;

import java.sql.Timestamp;

public interface TrailConditionNoImage {
    long getId();
    String getUsername();
    Timestamp getTimestamp();
    String getDescription();
    float getLat();
    float getLng();
    boolean getActive();
}
