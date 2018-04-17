package com.teamtwo.trails.trailCondition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrailConditionRepository extends CrudRepository<TrailConditionModel, Long>{
    List<TrailConditionModel> findByUsername(String username);
    List<TrailConditionModel> findAll();

    @Query("select point_of_interest.id, point_of_interest.username, point_of_interest.timestamp,point_of_interest.description,point_of_interest.lat,point_of_interest.lng,point_of_interest.approved,point_of_interest.active from point_of_interest")
    List<TrailConditionNoImage> findAllNoImage();

    TrailConditionModel getOne(long id);
    List<TrailConditionNoImage> findByActive(boolean active);
    List<TrailConditionNoImage> findByAcknowledged(boolean acknowledged);
    List<TrailConditionImage> findById(long id);
}
