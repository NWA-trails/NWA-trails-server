package com.teamtwo.trails.trailCondition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TrailConditionService {
    @Autowired
    TrailConditionRepository trailConditionRepository;

    public List<TrailConditionModel> getAll() { return trailConditionRepository.findAll(); }

    public List<TrailConditionNoImage> getAllNoImage() { return trailConditionRepository.findAllNoImage(); }


    public List<TrailConditionNoImage> getByActive(boolean active) { return trailConditionRepository.findByActive(active); }

    public List<TrailConditionNoImage> getByAcknowledged(boolean acknowledged) { return trailConditionRepository.findByAcknowledged(acknowledged); }

    public List<TrailConditionImage> getImageById(long id) { return trailConditionRepository.findById(id); }

    public void markInactiveById(long id) {
        TrailConditionModel condition = trailConditionRepository.getOne(id);
        condition.setActive(false);
        trailConditionRepository.save(condition);
    }

    public void markActiveById(long id) {
        TrailConditionModel condition = trailConditionRepository.getOne(id);
        condition.setActive(true);
        trailConditionRepository.save(condition);
    }

    public void markAcknowledgedById(long id) {
        TrailConditionModel condition = trailConditionRepository.getOne(id);
        condition.setAcknowledged(true);
        trailConditionRepository.save(condition);
    }

    public void markUnacknowledgedById(long id) {
        TrailConditionModel condition = trailConditionRepository.getOne(id);
        condition.setAcknowledged(false);
        trailConditionRepository.save(condition);
    }

    public List<TrailConditionModel> findByUsername( String username ) {
        return trailConditionRepository.findByUsername(username);
    }

    public void add(TrailConditionModel trailConditionModel) {
        Date date = new Date();
        trailConditionModel.setActive(true);
        trailConditionModel.setUsername(trailConditionModel.getUsername().toUpperCase());
        trailConditionModel.setTimestamp(new Timestamp(date.getTime()));
        trailConditionRepository.save(trailConditionModel);
    }

    public void delete(TrailConditionModel trailConditionModel) {
        trailConditionRepository.delete(trailConditionModel);
    }
}
