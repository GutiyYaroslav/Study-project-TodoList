package com.example.studytodolist.controllers;

import com.example.studytodolist.dto.UserDTO;
import com.example.studytodolist.models.User;
import com.example.studytodolist.services.UserService;
import com.example.studytodolist.utils.MessageBuilder;
import com.example.studytodolist.validators.utils.ObjectValidator;
import com.example.studytodolist.validators.utils.ValidationError;
import com.example.studytodolist.validators.utils.ValidationErrorResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Data
public class UserController {
    private final UserService userService;
    private final ObjectValidator<UserDTO> validator;

    @PostMapping
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        var violations = validator.validate(userDTO);
        if(violations != null){
            return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(userService.addUser(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity editUser(@RequestBody UserDTO userDTO, @PathVariable("userId") Long userId){
        var violations = validator.validate(userDTO);
        if(violations != null){
            return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
        }
        User currentUser = userService.editUser(userDTO, userId);
        if(currentUser != null){
            return new ResponseEntity(currentUser, HttpStatus.OK);
        }else{
            return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                    List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Long userId){
            User currentUser = userService.getUserById(userId);
            if(currentUser != null){
                return new ResponseEntity(currentUser, HttpStatus.OK);
            }else{
                return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                        List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                        HttpStatus.NOT_FOUND);
            }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId){
        if(userService.deleteUserById(userId)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                    List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                    HttpStatus.NOT_FOUND);
        }
    }
}

