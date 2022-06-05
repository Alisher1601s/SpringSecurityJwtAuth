package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.ZakupkaSyria;

public interface ZakupkaRepos extends JpaRepository<ZakupkaSyria,Integer> {

	
}
