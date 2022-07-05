package com.example.GymSystem.repository;

import com.example.GymSystem.model.trainers;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface trainersRepository extends JpaRepository<trainers,Long>{
    
}
