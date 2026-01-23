package com.joaopaulodevv.firstapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    public record Response(Long id, String name, String email){
        
    }

    public record Request(@NotBlank String name,@Email String email, String phone,@NotBlank String password){
        
    }
}


