package com.many_to_one_uni.controller;

import com.many_to_one_uni.entity.Users;
import com.many_to_one_uni.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepo repo;

    @GetMapping("/")
    public ResponseEntity<List> getAllUser(){
        List<Users> usersList =repo.findAll();
        if(usersList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usersList);
    }

    @PostMapping("/")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        Users saved=repo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
