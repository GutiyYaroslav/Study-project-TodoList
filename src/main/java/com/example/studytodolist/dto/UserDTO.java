package com.example.studytodolist.dto;

import com.example.studytodolist.validators.user.email.ValidEmail;
import com.example.studytodolist.validators.user.password.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}
