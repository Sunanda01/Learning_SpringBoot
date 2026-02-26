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
    public UserModel2 getUser(){
        System.out.println("Fetching User 1st time");
        UserModel2 user1=repo.findById(1L).orElseThrow();
        System.out.println("User Details => \nName => "+user1.getName());
        System.out.println("Fetching User 2nd time");
        UserModel2 user2=repo.findById(1L).orElseThrow();
        System.out.println("User Details => \nName => "+user2.getName());
        return user1;
    }

    @Transactional
    public void updateUser(Long id){
        System.out.println("Update User");
        UserModel2 user=repo.findById(id).orElseThrow();
        System.out.println("User Details => \nName => "+user.getName());
        user.setName("Sunanda Sadhu");
        repo.save(user);
    }
}
