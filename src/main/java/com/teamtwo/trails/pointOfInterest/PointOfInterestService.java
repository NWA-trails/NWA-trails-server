package com.teamtwo.trails.pointOfInterest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PointOfInterestService {
    @Autowired
    PointOfInterestRepository pointOfInterestRepository;

    public List<PointOfInterestModel> getAll() { return pointOfInterestRepository.findAll(); }

    public List<PointOfInterestModel> findByUsername( String username ) {
        return pointOfInterestRepository.findByUsername(username);
    }

    public void add(PointOfInterestModel PointOfInterestModel) {
        Date date = new Date();
        PointOfInterestModel.setTimestamp(new Timestamp(date.getTime()));
        pointOfInterestRepository.save(PointOfInterestModel);
    }

    public void delete(PointOfInterestModel PointOfInterestModel) {
        pointOfInterestRepository.delete(PointOfInterestModel);
    }
}
