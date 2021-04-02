package com.example.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoweb.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
