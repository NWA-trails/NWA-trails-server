package com.teamtwo.trails.emergencyContact;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmergencyContactRepository extends CrudRepository<EmergencyContactModel, Long> {
    List<EmergencyContactModel> findAll();
}
