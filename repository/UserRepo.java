package com.example.GymSystem.repository;

import com.example.GymSystem.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    
}
