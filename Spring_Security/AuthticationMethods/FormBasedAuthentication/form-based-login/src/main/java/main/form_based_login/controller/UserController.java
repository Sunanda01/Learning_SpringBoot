package main.form_based_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public String welcomePage(){
        return "welcome all";
    }

    @GetMapping("/user")
    public String userPage(){
        return "welcome user";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "welcome admin";
    }

    @GetMapping("/error")
    public String errorPage(){
        return "You are not authorized";
    }
}
