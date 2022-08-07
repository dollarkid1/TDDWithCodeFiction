package com.example.tddwithcodefiction.endpoints.unit.controller;

import com.example.tddwithcodefiction.endpoints.unit.service.DetailUserService;
import com.example.tddwithcodefiction.endpoints.unit.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{id}")
public class DetailUserController {

    @Autowired
    DetailUserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> list(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listUser(id));
    }
}
