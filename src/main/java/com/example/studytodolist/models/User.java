package com.example.studytodolist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder

public class User {
    private static Long customId = 0L;

    private Long id;

    private String firstName;


    private String lastName;


    private String email;


    private String password;


    @JsonIgnore
    private List<Task> tasks;

    public static Long createId(){
        return ++customId;
    }
}
