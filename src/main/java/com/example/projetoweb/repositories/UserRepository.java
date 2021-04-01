package com.example.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
