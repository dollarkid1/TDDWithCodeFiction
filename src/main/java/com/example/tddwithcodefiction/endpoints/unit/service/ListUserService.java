package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {

    @Autowired
    UserRepository repository;

    public List<User> listAllUsers() {
        return repository.findAll();
    }
}
