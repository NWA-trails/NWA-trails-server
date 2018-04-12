package com.teamtwo.trails.pointOfInterest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PointOfInterestService {
    @Autowired
    PointOfInterestRepository pointOfInterestRepository;

    public List<PointOfInterestModel> getAll() { return pointOfInterestRepository.findAll(); }

    public List<PointOfInterestNoImage> getByActive(boolean active) { return pointOfInterestRepository.findByActive(active); }

    public List<PointOfInterestNoImage> getByApproved(boolean approved) { return pointOfInterestRepository.findByApproved(approved); }

    public List<PointOfInterestImage> getImageById(long id) { return pointOfInterestRepository.findById(id); }

    public void markInactiveById(long id) {
        PointOfInterestModel pointOfInterest = pointOfInterestRepository.getOne(id);
        pointOfInterest.setActive(false);
        pointOfInterestRepository.save(pointOfInterest);
    }

    public void markActiveById(long id) {
        PointOfInterestModel pointOfInterest = pointOfInterestRepository.getOne(id);
        pointOfInterest.setActive(true);
        pointOfInterestRepository.save(pointOfInterest);
    }

    public void markApprovedById(long id) {
        PointOfInterestModel pointOfInterest = pointOfInterestRepository.getOne(id);
        pointOfInterest.setApproved(true);
        pointOfInterestRepository.save(pointOfInterest);
    }

    public void markUnapprovedById(long id) {
        PointOfInterestModel pointOfInterest = pointOfInterestRepository.getOne(id);
        pointOfInterest.setApproved(false);
        pointOfInterestRepository.save(pointOfInterest);
    }
    
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
