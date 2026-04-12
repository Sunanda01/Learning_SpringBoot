package com.spring_oauth_demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @GetMapping("/")
    public String home(){
        return "Go to /oauth2/authorization/github to login";
    }
    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OAuth2User user) {
        return "Hello " + user.getAttribute("login");
    }
}
