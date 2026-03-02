package com.spring_boot_security_demo.repository;

import com.spring_boot_security_demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}
