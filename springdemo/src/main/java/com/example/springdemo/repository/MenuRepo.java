package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Integer>{
    Menu findByFoodName(String foodName);
    
}
