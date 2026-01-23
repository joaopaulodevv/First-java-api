package com.joaopaulodevv.firstapi.config;

import com.joaopaulodevv.firstapi.model.User;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.joaopaulodevv.firstapi.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("João Paulo","a@g.com","21979627818","123");
        User u2 = new User("Maria","a@g.com","21987654321","321");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
