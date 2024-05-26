package com.javatech.practicerecords.controller;

import com.javatech.practicerecords.model.User;
import com.javatech.practicerecords.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.of(Optional.ofNullable(userService.getAllUsers()));
    }
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.of(Optional.ofNullable(userService.addUser(user)));
    }
    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
        return ResponseEntity.of(Optional.ofNullable(userService.getUserByName(name)));
    }

}
