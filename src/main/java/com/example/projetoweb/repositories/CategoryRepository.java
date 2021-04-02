package com.example.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoweb.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
