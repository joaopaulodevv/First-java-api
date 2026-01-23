package com.joaopaulodevv.firstapi.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaopaulodevv.firstapi.dto.UserDTO;
import com.joaopaulodevv.firstapi.exception.EmailAlreadyExistsException;
import com.joaopaulodevv.firstapi.model.User;
import com.joaopaulodevv.firstapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository  userRepository;

    public List<UserDTO.Response> getUsers(){

        List<User> users = userRepository.findAll();
        
        return users.stream().map(user -> new UserDTO.Response(user.getId(),user.getName(),user.getEmail())).toList();
        
    }

    public UserDTO.Response getUserById(Long id) {
        return userRepository.findById(id)
            .map(user -> new UserDTO.Response(
                user.getId(), 
                user.getName(), 
                user.getEmail()
            ))
            .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public UserDTO.Response insert(UserDTO.Request obj){
        User user = new User(obj.name(), obj.email(), obj.password(), obj.phone());

        if (userRepository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        userRepository.save(user);

        return new UserDTO.Response(user.getId(),user.getName(),user.getEmail());
    }


}
