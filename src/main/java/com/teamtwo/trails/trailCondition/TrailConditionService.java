package com.teamtwo.trails.trailCondition;

import com.teamtwo.trails.wrapper.TrailConditionStringWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TrailConditionService {
    @Autowired
    TrailConditionRepository trailConditionRepository;

    public List<TrailConditionModel> getAll() { return trailConditionRepository.findAll(); }

    //repositrory function not yet built
    //public List<TrailConditionNoImage> getAllNoImage() { return trailConditionRepository.findAllNoImage(); }


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

    public void addWithStringImage(TrailConditionStringWrapper trailConditionStringWrapper) {
        TrailConditionModel trailConditionModel = new TrailConditionModel();
        trailConditionModel.setDescription(trailConditionStringWrapper.getDescription());
        trailConditionModel.setLat(trailConditionStringWrapper.getLat());
        trailConditionModel.setLng(trailConditionStringWrapper.getLng());
        byte[] bytes = trailConditionStringWrapper.getImage().getBytes(StandardCharsets.UTF_8);
        Byte[] image = new Byte[bytes.length];
        int i = 0;
        for(byte b: bytes)
            image[i++] = b;
        trailConditionModel.setImage(image);
        trailConditionModel.setActive(true);
        trailConditionModel.setAcknowledged(false);
        trailConditionModel.setUsername(trailConditionStringWrapper.getUsername().toUpperCase());
        Date date = new Date();
        trailConditionModel.setTimestamp(new Timestamp(date.getTime()));
        trailConditionRepository.save(trailConditionModel);
    }

    public void delete(long id) {
        trailConditionRepository.delete(id);
    }
}
