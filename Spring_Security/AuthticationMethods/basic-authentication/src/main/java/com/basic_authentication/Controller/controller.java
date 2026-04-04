package com.basic_authentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/public")
    public String publicApi() {
        return "Public API - No Auth Needed";
    }

    @GetMapping("/user")
    public String userApi() {
        return "Hello USER";
    }

    @GetMapping("/admin")
    public String adminApi() {
        return "Hello ADMIN";
    }
}
