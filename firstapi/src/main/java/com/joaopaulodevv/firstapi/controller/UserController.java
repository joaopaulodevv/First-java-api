package com.joaopaulodevv.firstapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopaulodevv.firstapi.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User("João Paulo","123@G.COM","21979627818","123");
        
        List<User> tropa = new ArrayList<>();
        tropa.add(user);
        tropa.add(new User("Maria","12@g.com","21987654321","321"));
        
        
        return ResponseEntity.ok().body(tropa);
    }
}
