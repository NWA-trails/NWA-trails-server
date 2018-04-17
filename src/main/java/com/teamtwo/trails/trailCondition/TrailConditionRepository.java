package com.teamtwo.trails.trailCondition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrailConditionRepository extends CrudRepository<TrailConditionModel, Long>{
    List<TrailConditionModel> findByUsername(String username);
    List<TrailConditionModel> findAll();

    @Query("select id, username, timestamp,description,lat,trail_condition.lng,acknowledged,active from trail_condition")
    List<TrailConditionNoImage> findAllNoImage();

    TrailConditionModel getOne(long id);
    List<TrailConditionNoImage> findByActive(boolean active);
    List<TrailConditionNoImage> findByAcknowledged(boolean acknowledged);
    List<TrailConditionImage> findById(long id);
}
