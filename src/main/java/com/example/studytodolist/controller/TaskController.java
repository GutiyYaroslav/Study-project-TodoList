package com.example.studytodolist.controller;


import com.example.studytodolist.dto.TaskDTO;
import com.example.studytodolist.dto.UserDTO;
import com.example.studytodolist.model.User;
import com.example.studytodolist.validators.utils.ObjectValidator;
import com.example.studytodolist.validators.utils.ValidationError;
import com.example.studytodolist.validators.utils.ValidationErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class TaskController {

    private final ObjectValidator<TaskDTO> validator;

    private final UserController userController;

    @GetMapping("/{userId}/tasks")
    public ResponseEntity getAllTask(@PathVariable("userId") Long userId){

//      Attempt to find a user by id from the request parameter

        Optional<User> userFromOptional = userController.getUserList().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if(userFromOptional.isPresent()){
            return new ResponseEntity(userFromOptional.get().getTasks(), HttpStatus.OK);
        }

        return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                HttpStatus.NOT_FOUND);

    }
}
