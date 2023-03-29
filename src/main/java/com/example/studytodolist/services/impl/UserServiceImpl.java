package com.example.studytodolist.services.impl;

import com.example.studytodolist.dto.UserDTO;
import com.example.studytodolist.models.User;
import com.example.studytodolist.services.UserService;
import com.example.studytodolist.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User getUserById(Long userId) {
        return userList.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst().get();
    }

    @Override
    public boolean deleteUserById(Long userId) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(userId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User createdUser = User.builder()
                .id(User.createId())
                .firstName(userDTO.getFirstName().trim())
                .lastName(userDTO.getLastName().trim())
                .email(userDTO.getEmail().trim())
                .password(userDTO.getPassword().trim())
                .build();
        userList.add(createdUser);
        return createdUser;
    }

    @Override
    public User editUser(UserDTO userDTO, Long userId) {
        User currentUser = null;
        Optional<User> userToUpdate = userList.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if (userToUpdate.isPresent()) {
            User userIter = userToUpdate.get();
            userIter.setFirstName(userDTO.getFirstName());
            userIter.setLastName(userDTO.getLastName());
            userIter.setEmail(userDTO.getEmail());
            userIter.setPassword(userDTO.getPassword());
            currentUser = userIter;
        }
        return currentUser;
    }
}
