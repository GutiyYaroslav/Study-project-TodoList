package com.example.studytodolist.controller;

import com.example.studytodolist.dto.UserDTO;
import com.example.studytodolist.model.User;
import com.example.studytodolist.validators.utils.MessageBuilder;
import com.example.studytodolist.validators.utils.ObjectValidator;
import com.example.studytodolist.validators.utils.ValidationError;
import com.example.studytodolist.validators.utils.ValidationErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final ObjectValidator<UserDTO> validator;

    // Database simulation
    private List<User> userList = new ArrayList<>();

    @PostMapping
    public ResponseEntity register(@RequestBody UserDTO userDTO) {

//      Validation of DTO object and handling the case when the request object fails validation.

        var violations = validator.validate(userDTO);
        if(violations != null){
            return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
        }

//      Simulating the creation of a User object based on a DTO object
//          and returning the newly created User object in the response.

        User createdUser = User.builder()
                .id(User.createId())
                .firstName(userDTO.getFirstName().trim())
                .lastName(userDTO.getLastName().trim())
                .email(userDTO.getEmail().trim())
                .password(userDTO.getPassword().trim())
                .build();
        userList.add(createdUser);

        return new ResponseEntity(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity editUser(@RequestBody UserDTO userDTO, @PathVariable("userId") Long userId){

//      Validation of DTO object and handling the case when the request object fails validation.

        var violations = validator.validate(userDTO);
        if(violations != null){
            return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
        }

//      Attempt to find a user by id from the request parameter and update their information.

        Optional<User> userToUpdate = userList.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if (userToUpdate.isPresent()) {
            User userIter = userToUpdate.get();
            userIter.setFirstName(userDTO.getFirstName());
            userIter.setLastName(userDTO.getLastName());
            userIter.setEmail(userDTO.getEmail());
            userIter.setPassword(userDTO.getPassword());
            return new ResponseEntity(userIter, HttpStatus.OK);
        }

//      Handling the case when there is no user with the given id from the request parameter.

        return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public ResponseEntity getAllUsers(){

//      Handling the case when the list of users is empty.

        if(userList.isEmpty()){
            return new ResponseEntity(new MessageBuilder("There are currently no created users."), HttpStatus.OK);
        }
//      Return all users

        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Long userId){

//      Attempt to find a user by id from the request parameter and return user

        Optional<User> userFromOptional = userList.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if(userFromOptional.isPresent()){
            return new ResponseEntity(userFromOptional.get(), HttpStatus.OK);
        }else{

//      Handling the case when there is no user with the given id from the request parameter.

            return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                    List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                    HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId){

//      Attempt to find a user by id from the request parameter and delete user

        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(userId)) {
                iterator.remove();
                return new ResponseEntity(new MessageBuilder("User with id - " +userId+ " has been deleted."),
                        HttpStatus.NO_CONTENT);
            }
        }

//      Handling the case when there is no user with the given id from the request parameter.

        return new ResponseEntity(new ValidationErrorResponse("invalid request parameter",
                List.of(new ValidationError("request parameter", "User with id " + userId + " does not exist."))),
                HttpStatus.NOT_FOUND);

    }


}

