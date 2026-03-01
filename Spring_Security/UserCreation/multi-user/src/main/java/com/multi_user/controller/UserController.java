package com.multi_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping
    public String welcomePage(){
        return "welcome";
    }

    @GetMapping("/user")
    public String userPage(){
        return "user-page";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin-page";
    }

}
