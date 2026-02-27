package com.one_to_one_bi.controller;


import com.one_to_one_bi.entity.User;
import com.one_to_one_bi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepo repo;

    @GetMapping("/")
    public String getAllUser(){
        List<User> userList=repo.findAll();
        if(userList.isEmpty())
            return "Empty List";
        return "List Of User\n"+userList;
    }

    @PostMapping("/")
    public String createUser(@RequestBody User user){
        repo.save(user);
        return "User Saved";
    }

}
