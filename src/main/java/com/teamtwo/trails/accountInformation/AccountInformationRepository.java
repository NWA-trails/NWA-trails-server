package com.teamtwo.trails.accountInfromation;

import org.springframework.data.repository.CrudRepository;

public interface AccountInformationRepository extends CrudRepository<AccountInformationModel, Long> {

    AccountInformationModel findByUsername(String userName);
}
