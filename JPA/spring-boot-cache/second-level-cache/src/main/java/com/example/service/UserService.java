package com.example.service;

import com.example.entity.UserModel2;
import com.example.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo repo;
    @Transactional
    public void getUser(){
        System.out.println("Fetching User 1st time");
        UserModel2 user1=repo.findById(1L).orElseThrow();
        System.out.println("Fetching User 2nd time");
        UserModel2 user2=repo.findById(1L).orElseThrow();
        System.out.println("User1 == User2 => "+(user1==user2));
    }
}
