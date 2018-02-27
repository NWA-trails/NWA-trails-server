package com.teamtwo.trails.emergencyContact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyContactService {


    @Autowired
    EmergencyContactRepository emergencyContactRepository;


    public List<EmergencyContactModel> getAll() {
        return emergencyContactRepository.findAll();
    }

    //public void addEmergencyContact(EmergencyContactModel emergencyContactRepository) {}

}

