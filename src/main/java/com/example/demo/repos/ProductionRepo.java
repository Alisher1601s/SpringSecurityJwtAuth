package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Production;

public interface ProductionRepo extends JpaRepository<Production,Integer>{

}
