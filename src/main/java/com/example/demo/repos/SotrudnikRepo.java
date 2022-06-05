package com.example.demo.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.demo.models.Doljnost;
import com.example.demo.models.Sotrudnik;
public interface SotrudnikRepo extends JpaRepository<Sotrudnik,Integer>{
@Procedure
List<Sotrudnik>findsotrudnik();
@Procedure
Sotrudnik findbysotrudnikid(int s);
@Procedure
void updatesotrudnik(int ks,String fiop,String adresp,int okladp,String phonep,Doljnost doljnostp);
@Procedure
void addsotrudnik(String fiop,String adresp,int okladp,String phonep,Doljnost doljnostp);
@Procedure
void delsotrudnik(int ks);	
}
