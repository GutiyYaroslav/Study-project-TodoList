package com.example.studytodolist.controllers;


import com.example.studytodolist.dto.TaskDTO;
import com.example.studytodolist.models.User;
import com.example.studytodolist.validators.utils.ObjectValidator;
import com.example.studytodolist.validators.utils.ValidationError;
import com.example.studytodolist.validators.utils.ValidationErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class TaskController {

    private final ObjectValidator<TaskDTO> validator;

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

    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity getTaskFromUserById(@PathVariable("userId") Long userId,
                                              @PathVariable("taskId") Long taskId){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{userId}/tasks")
    public ResponseEntity addTaskToUser(@PathVariable("userId") Long userId,
                                        @RequestBody TaskDTO taskDTO){
        var violations = validator.validate(taskDTO);
        if(violations != null){
            return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity editTaskFromUser(@PathVariable("userId") Long userId,
                                           @PathVariable("taskId") Long taskId,
                                           @RequestBody TaskDTO taskDTO){
        var violations = validator.validate(taskDTO);
        if(violations != null){
            return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity deleteTaskFromUser(@PathVariable("userId") Long userId,
                                             @PathVariable("taskId") Long taskId){
        return new ResponseEntity(HttpStatus.OK);
    }

}
