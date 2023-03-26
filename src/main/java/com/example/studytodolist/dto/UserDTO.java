package com.example.studytodolist.dto;

import com.example.studytodolist.validators.user.email.ValidEmail;
import com.example.studytodolist.validators.user.password.ValidPassword;
import com.example.studytodolist.validators.user.somename.ValidSomeName;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {

    @ValidSomeName(message = "Invalid firstName field: The field firstName should not contain digits or symbols and must not be empty")
    private String firstName;

    @ValidSomeName(message = "Invalid lastName field: The field lastName should not contain digits or symbols and must not be empty")
    private String lastName;

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}
