package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserNotFoundException;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {

    @Autowired
    UserRepository repository;

    public User updateUser(Long id, User user) {

        repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setId(id);
        return repository.save(user);
    }
}
