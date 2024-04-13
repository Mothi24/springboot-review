package com.example.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.model.Signup;
import com.example.springdemo.repository.SignRepo;

@Service
public class SignService {
    
    @Autowired
    private SignRepo signRepo;

    public Signup signup(Signup signup)
    {
        return signRepo.save(signup);
    }
    public Signup getUser(String email)
    {
        return signRepo.findByEmailId(email);
    }
    public Signup loginCheck(String email,String password)
    {
        return signRepo.findByEmailIdAndPassword(email, password);
    }
    
}
