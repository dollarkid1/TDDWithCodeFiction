package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.UserNotFoundException;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    @Autowired
    UserRepository repository;

    public void deleteUser(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        repository.deleteById(id);
    }
}
