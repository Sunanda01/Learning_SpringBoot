package com.one_to_many_uni.controller;

import com.one_to_many_uni.entity.Users;
import com.one_to_many_uni.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepo repo;

    @GetMapping("/")
    public String getAllUser(){
        List<Users> usersList =repo.findAll();
        if(usersList.isEmpty())
            return "Empty List";
        return "List Of User\n"+ usersList;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id){
        if(!repo.existsById(id))
            return "User Not Found";
        Users user=repo.findById(id).orElseThrow();
        user.getOrderList().remove(0);
        repo.save(user);
        return "User With Id => "+id+" details\n"+ user;
    }

    @PostMapping("/")
    public String createUser(@RequestBody Users users){
        repo.save(users);
        return "User Saved";
    }

}
