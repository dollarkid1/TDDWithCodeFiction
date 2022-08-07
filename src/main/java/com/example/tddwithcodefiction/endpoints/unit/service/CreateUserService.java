package com.example.tddwithcodefiction.endpoints.unit.service;


import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    UserRepository repository;

    public User createNewUser(User user) {
        return repository.save(user);
    }
}

