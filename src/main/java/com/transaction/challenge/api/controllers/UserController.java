package com.transaction.challenge.api.controllers;

import com.transaction.challenge.api.application.model.entities.User;
import com.transaction.challenge.api.application.services.UserService;
import com.transaction.challenge.api.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = this.service.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<User> findOneUser(@PathVariable Long id){
        User user = this.service.findOneUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User user1 = this.service.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

}
