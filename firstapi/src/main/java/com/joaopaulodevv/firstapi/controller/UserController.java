package com.joaopaulodevv.firstapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopaulodevv.firstapi.dto.UserDTO;
import com.joaopaulodevv.firstapi.service.UserService;

import jakarta.validation.Valid;

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

    @PostMapping
    public ResponseEntity<UserDTO.Response> insert(@Valid @RequestBody UserDTO.Request obj){
        UserDTO.Response res = userService.insert(obj);

        URI location = URI.create(String.format("/users/%s", res.id()));
        return ResponseEntity.created(location).body(res);
    }
}
