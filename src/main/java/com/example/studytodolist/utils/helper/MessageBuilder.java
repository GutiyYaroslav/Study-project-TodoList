package com.example.studytodolist.utils.helper;

import lombok.Data;

@Data
public class MessageBuilder {

    private String message;

    public MessageBuilder(String message){
        this.message = message;
    }
}
