package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserNotFoundException;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailUserService {

    @Autowired
    UserRepository repository;

    public User listUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
