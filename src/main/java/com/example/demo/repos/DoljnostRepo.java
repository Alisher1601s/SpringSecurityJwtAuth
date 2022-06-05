package com.example.demo.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Doljnost;
@Repository
public interface DoljnostRepo  extends JpaRepository<Doljnost,Integer>{
@Procedure
List<Doljnost>finddoljnost();
@Procedure
void updatedoljnost(String s,int s2);
@Procedure
void deletedoljnost(int s);
@Procedure
Doljnost findbyid(int s);
@Procedure
void adddoljnost(String s);
}
