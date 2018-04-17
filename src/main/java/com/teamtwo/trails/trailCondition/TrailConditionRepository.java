package com.teamtwo.trails.trailCondition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrailConditionRepository extends CrudRepository<TrailConditionModel, Long>{
    List<TrailConditionModel> findByUsername(String username);
    List<TrailConditionModel> findAll();

    @Query("select id, username, timestamp,description,lat,lng,approved,active from point_of_interest")
    List<TrailConditionNoImage> findAllNoImage();

    TrailConditionModel getOne(long id);
    List<TrailConditionNoImage> findByActive(boolean active);
    List<TrailConditionNoImage> findByAcknowledged(boolean acknowledged);
    List<TrailConditionImage> findById(long id);
}
