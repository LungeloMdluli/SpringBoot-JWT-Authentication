package com.StandardBankForage.SBA;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class Controller {

    @GetMapping(("/hello"))
    public String hello(){
        return "Lungelo Mdluli";
    }


    @PostMapping("/authenticate")

    public String authenticate(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();


        ObjectMapper objectMapper = new ObjectMapper();


        try {
            //Read Json file with the user details
            JsonNode rootNode = objectMapper.readTree(new File("Config.json"));

            //Access the data of the user stored in the Json file
            String StoredUsername = rootNode.get("username").asText();
            String StoredUserPassword = rootNode.get("password").asText();


            if (username.equals(StoredUsername) && password.equals(StoredUserPassword)){
                return username +" You have been logged in successfully........";

            }else{
                return "Invalid details";
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



//        return username +" You have been logged in successfully........";
    }


}

