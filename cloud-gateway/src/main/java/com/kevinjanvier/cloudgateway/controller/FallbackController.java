package com.kevinjanvier.cloudgateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FallbackController {

    @GetMapping("/profileServiceFallback")
    public String profileServiceFallback(){
        return "Profile Service is Down !";
      //  return new ResponseEntity(Collections.emptyList(), HttpStatus.OK);
    }

    @GetMapping("/fitnessPlanServiceFallback")
    public String fitnessPlanServiceFallback(){
        return "Fitness Plan Service is Down !";
    }
}
