package com.example.demo.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;
public interface ProductRepo extends JpaRepository <Product,Integer>{

}
