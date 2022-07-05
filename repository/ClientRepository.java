package com.example.GymSystem.repository;

import com.example.GymSystem.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}
