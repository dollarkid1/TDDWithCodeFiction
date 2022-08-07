package com.example.tddwithcodefiction.endpoints.unit.controller;

import com.example.tddwithcodefiction.endpoints.unit.service.UpdateUserService;
import com.example.tddwithcodefiction.endpoints.unit.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{id}")
public class UpdateUserController {

    @Autowired
    private UpdateUserService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser_whenPutUser(@RequestBody User user, @PathVariable Long id){
        return ResponseEntity.ok().body(service.updateUser(id, user));
    }
}
