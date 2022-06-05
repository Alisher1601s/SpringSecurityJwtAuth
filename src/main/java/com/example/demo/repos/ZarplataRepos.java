package com.example.demo.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.zarplata;
public interface ZarplataRepos extends JpaRepository<zarplata,Integer> {

}
