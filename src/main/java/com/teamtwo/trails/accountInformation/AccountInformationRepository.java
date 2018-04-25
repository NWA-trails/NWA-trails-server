package com.teamtwo.trails.accountInformation;

import com.teamtwo.trails.user.UserDetailsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountInformationRepository extends CrudRepository<AccountInformationModel, Long> {
    AccountInformationModel findByUsername(String userName);
}
