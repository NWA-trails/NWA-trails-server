package com.teamtwo.trails.accountInfromation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountInformation")
public class AccountInformationController {

    @Autowired
    AccountInformationService accountInformationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home()  {
        return "{\"text\":\"Account Information\"}";
    }

    @RequestMapping(value = "/getAccountInformation?userId={userId}", method = RequestMethod.GET)
    public ResponseEntity<AccountInformationModel> getAccountInformation(@Param (value = "userName") final String userName) {
        return new ResponseEntity<>(accountInformationService.getAccountInformation(userName), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateAccountInformation", method = RequestMethod.POST)
    public void updateAccountInformation(@RequestBody AccountInformationModel accountInformationModel) {
        accountInformationService.updateAccountInformation(accountInformationModel);
    }

}
