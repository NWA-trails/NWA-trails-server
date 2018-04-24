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
        AccountInformationModel accountInfo = this.accountInformationRepository.findByUsername(accountInformationModel.getUsername());

        System.out.println("Account Model ID is: " + accountInformationModel.getId() + " username is: " + accountInformationModel.getUsername());
        System.out.println("Account Info ID is: " + accountInfo.getId() + " username is: " + accountInfo.getUsername());
        if (accountInfo.getUsername() != null) {
            accountInfo.setDateofbirth(accountInformationModel.getDateofbirth());
            accountInfo.setHeight(accountInformationModel.getHeight());
            accountInfo.setWeight(accountInformationModel.getWeight());

            accountInformationRepository.save(accountInfo);
        } else {
            accountInformationRepository.save(accountInformationModel);
        }
    }
}
