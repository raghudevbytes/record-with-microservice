package com.javatech.practicerecords.model;


import com.javatech.practicerecords.UserRepository;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank String id, @NotBlank String name, int age) {
    public UserRequest{
        if(age<0 || age>=100){
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
    }
}
