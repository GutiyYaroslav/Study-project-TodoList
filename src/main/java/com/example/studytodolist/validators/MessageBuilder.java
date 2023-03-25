package com.example.studytodolist.validators;

import lombok.Data;

@Data
public class MessageBuilder {

    private String message;

    public MessageBuilder(String message){
        this.message = message;
    }
}
