package com.teamtwo.trails.trailCondition;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrailConditionRepository extends CrudRepository<TrailConditionModel, Long>{
    List<TrailConditionModel> findByUsername(String username);
    List<TrailConditionModel> findAll();
    TrailConditionModel getOne(long id);
    List<TrailConditionNoImage> findByActive(boolean active);
    List<TrailConditionImage> findById(long id);
}
