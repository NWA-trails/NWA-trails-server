package com.teamtwo.trails.pointOfInterest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointOfInterestRepository extends CrudRepository<PointOfInterestModel, Long> {
    List<PointOfInterestModel> findAll();
    List<PointOfInterestModel> findByUsername(String username);

}
