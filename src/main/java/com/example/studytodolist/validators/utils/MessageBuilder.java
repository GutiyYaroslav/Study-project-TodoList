package com.example.studytodolist.validators.utils;

import lombok.Data;

@Data
public class MessageBuilder {

    private String message;

    public MessageBuilder(String message){
        this.message = message;
    }
}
