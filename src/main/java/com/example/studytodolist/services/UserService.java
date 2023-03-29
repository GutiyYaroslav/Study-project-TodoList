package com.example.studytodolist.services;

import com.example.studytodolist.dto.UserDTO;
import com.example.studytodolist.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    boolean deleteUserById(Long userId);
    User addUser(UserDTO userDTO);
    User editUser(UserDTO userDTO, Long userId);
}
