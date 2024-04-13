package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Signup;

@Repository
public interface SignRepo extends JpaRepository<Signup,String>{
    
    Signup findByEmailId(String emailId);
    Signup findByEmailIdAndPassword(String emailId, String password);
}