package com.joaopaulodevv.firstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopaulodevv.firstapi.dto.UserDTO;
import com.joaopaulodevv.firstapi.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserDTO.Response>> findAll() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO.Response> findById(@PathVariable Long id){
        UserDTO.Response user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
