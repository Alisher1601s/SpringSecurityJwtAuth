package com.example.demo.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProdajaProdukcii;
public interface ProdajaProdRepo extends JpaRepository< ProdajaProdukcii,Integer > {

}
