package com.teamtwo.trails.accountInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @RequestMapping(value = "/getAccountInformation/{username}", method = RequestMethod.GET)
    public ResponseEntity<AccountInformationModel> getAccountInformation(@PathVariable String username) {
        return new ResponseEntity<>(accountInformationService.getAccountInformation(username), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateAccountInformation", method = RequestMethod.POST)
    public void updateAccountInformation(@RequestBody AccountInformationModel accountInformationModel) {
        accountInformationService.updateAccountInformation(accountInformationModel);
    }

}
