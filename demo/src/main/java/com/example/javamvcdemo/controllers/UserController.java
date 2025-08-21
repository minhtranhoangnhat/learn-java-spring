package com.example.javamvcdemo.controllers;

import com.example.javamvcdemo.models.User;
import com.example.javamvcdemo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username){
        User user = userRepository.findByUsername(username);
        if(user == null) return ResponseEntity.notFound().build();
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
