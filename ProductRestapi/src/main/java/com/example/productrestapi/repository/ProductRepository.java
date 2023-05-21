package com.example.productrestapi.repository;

import com.example.productrestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, String>{
    void delete(String id);
}
