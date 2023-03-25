package com.example.studytodolist.service;

import com.example.studytodolist.dto.UserDTO;
import com.example.studytodolist.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final ObjectValidator validator;

    public String addUser(UserDTO user){
//        var violations = validator.validate(user);
//        if(!violations.isEmpty()){
//            return String.join("\n", violations);
//        }
        return "there aren't any problems";
    }



}
