package com.example.studytodolist.dto;

import com.example.studytodolist.model.User;
import lombok.Data;

@Data

public class TaskDTO {

    private Long id;

    private String taskName;

    private boolean completed;

    private User user;

}