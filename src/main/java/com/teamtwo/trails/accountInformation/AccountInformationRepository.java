package com.teamtwo.trails.accountInformation;

import org.springframework.data.repository.CrudRepository;

public interface AccountInformationRepository extends CrudRepository<AccountInformationModel, Long> {
    AccountInformationModel findByUsername(String userName);
}
