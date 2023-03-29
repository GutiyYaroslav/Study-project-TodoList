package com.example.studytodolist.dto;

import com.example.studytodolist.models.User;
import com.example.studytodolist.validators.task.ValidTaskName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data

public class TaskDTO {
    @ValidTaskName
    private String taskName;

    @JsonIgnore
    private User user;

}