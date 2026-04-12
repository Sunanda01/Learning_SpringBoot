package com.spring_oauth_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String home(){
        return "Go to http://localhost:8080/oauth2/authorization/google";
    }
}
