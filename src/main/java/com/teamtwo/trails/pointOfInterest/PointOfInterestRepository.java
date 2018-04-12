package com.teamtwo.trails.pointOfInterest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointOfInterestRepository extends CrudRepository<PointOfInterestModel, Long> {
    List<PointOfInterestModel> findByUsername(String username);
    List<PointOfInterestModel> findAll();
    PointOfInterestModel getOne(long id);
    List<PointOfInterestNoImage> findByActive(boolean active);
    List<PointOfInterestNoImage> findByApproved(boolean approved);
    List<PointOfInterestImage> findById(long id);
}
