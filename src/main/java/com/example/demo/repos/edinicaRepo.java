package com.example.demo.repos;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.models.edinica;
@Repository
public interface edinicaRepo extends JpaRepository<edinica,Integer> {
@Procedure
List<edinica>finded();
@Procedure
edinica findbyedid(int s);
@Procedure
void deledinica(int s);
@Procedure
void addedinica(String edinicaname);
@Procedure
void updateedinica(int s,String edinicaname);
}
