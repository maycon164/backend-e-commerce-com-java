package com.example.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoweb.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
