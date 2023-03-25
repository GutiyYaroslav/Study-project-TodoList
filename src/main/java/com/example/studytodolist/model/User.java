package com.example.studytodolist.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private static Long customId = 0L;

    private Long id;

    private String firstName;


    private String lastName;


    private String email;


    private String password;

    public static Long createId(){
        return ++customId;
    }
}
