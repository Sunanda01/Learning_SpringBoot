package com.one_to_many_bi.controller;

import com.one_to_many_bi.entity.Order;
import com.one_to_many_bi.entity.Users;
import com.one_to_many_bi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        for(Order order: user.getOrderList())
            order.setUsers(user);
        Users saved=repo.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
