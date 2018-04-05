package com.teamtwo.trails.trailCondition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailConditionService {
    @Autowired
    TrailConditionRepository trailConditionRepository;

    public List<TrailConditionModel> getAll() { return trailConditionRepository.findAll(); }

    public List<TrailConditionModel> findByUsername( String username ) {
        return trailConditionRepository.findByUsername(username);
    }

    public void add(TrailConditionModel trailConditionModel) {
        trailConditionRepository.save(trailConditionModel);
    }

    public void delete(TrailConditionModel trailConditionModel) {
        trailConditionRepository.delete(trailConditionModel);
    }
}
