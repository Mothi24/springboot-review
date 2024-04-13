package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Cart;

@Repository
public interface CartRepo extends JpaRepository <Cart,Integer>{
    
}
