package com.example.demo.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.demo.models.Product;
import com.example.demo.models.Syrie;
import com.example.demo.models.edinica;
public interface SyrieRepo extends JpaRepository <Syrie,Integer>{
@Procedure
List<Syrie>findsyrie();
@Procedure
Syrie findbysyrieid(int ks);
@Procedure
void delsyrie(int ks);
@Procedure
void updatesyrie(int ks,double kolvop,String namep,double summap,edinica edinica);
@Procedure
void adsyrie(double kolvop,String namep,double summap,edinica edinica);
}
