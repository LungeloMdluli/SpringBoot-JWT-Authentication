package com.StandardBankForage.SBA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(("/hello"))
    public String hello(){
        return "Lungelo Mdluli";
    }


    @PostMapping("/login")

    public String login(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();


        return username +" You have been logged in successfully........";
    }


}

