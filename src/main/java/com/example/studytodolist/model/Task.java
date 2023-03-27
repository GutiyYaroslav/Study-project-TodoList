package com.example.studytodolist.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {

    private static Long customId = 0L;

    private Long id;

    private String taskName;

    private boolean completed;

    private User user;

    public static Long createId(){
        return ++customId;
    }
}
