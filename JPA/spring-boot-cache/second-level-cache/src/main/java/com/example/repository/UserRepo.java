package com.example.repository;

import com.example.entity.UserModel2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel2,Long> {
}
