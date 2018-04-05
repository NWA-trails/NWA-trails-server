package com.teamtwo.trails.accountInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInformationService {

    @Autowired
    AccountInformationRepository accountInformationRepository;

    public AccountInformationModel getAccountInformation(String userName) {
        return accountInformationRepository.findByUsername(userName);
    }

    public void updateAccountInformation(AccountInformationModel accountInformationModel) {
        accountInformationRepository.save(accountInformationModel);
    }
}
