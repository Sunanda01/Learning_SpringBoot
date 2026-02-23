package com.example.service;

import com.example.model.UserModel;
import com.example.repository.Repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Repo repo;
    @Transactional
    public void firstLevelCache(){
        System.out.println("Fetching First Time");
        UserModel user1=repo.findById(1L).orElseThrow();
        System.out.println("Fetching Second Time");
        UserModel user2=repo.findById(1L).orElseThrow();
        System.out.println("Are Objects Same => "+(user1==user2));
    }

}
