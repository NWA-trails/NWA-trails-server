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

        accountInfo.setDateofbirth(accountInformationModel.getDateofbirth());
        accountInfo.setHeight(accountInformationModel.getHeight());
        accountInfo.setWeight(accountInformationModel.getWeight());

        accountInformationRepository.save(accountInfo);
    }
}
