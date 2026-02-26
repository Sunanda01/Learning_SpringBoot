package com.auto.controller;

import com.auto.entity.User;
import com.auto.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepo repo;
    @PostMapping("/")
    public String createUser(@RequestBody User user){
        repo.save(user);
        return "User Saved\n"+user;
    }

    @GetMapping("/")
    public String getUser(){
        List<User> userList=repo.findAll();
        if(userList.isEmpty())
            return "No Users Found";
        else
            return "List Of Users\n"+userList;
    }
}
