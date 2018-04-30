package com.teamtwo.trails.accountInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountInformation")
public class AccountInformationController {

    @Autowired
    AccountInformationService accountInformationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home()  {
        return "{\"text\":\"Account Information\"}";
    }

    @RequestMapping(value = "/updateAccountInformation", method = RequestMethod.POST)
    public ResponseEntity<String> updateAccount(@RequestBody AccountInformationModel accountInformationModel) {
        accountInformationService.updateAccountInformation(accountInformationModel);
        return new ResponseEntity<>("{\"message\":\"Updated account info.\"}", HttpStatus.OK);
    }

}
