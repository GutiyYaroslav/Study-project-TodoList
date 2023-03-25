package com.example.studytodolist.controller;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Test
    void register() {
    }

    @Test
    void editUser() {
    }

//    @Test
//    public void testGetAllUsersWithEmptyList() throws Exception {
//        // Given
//        Mockito.when(userController.getAllUsers())
//                .thenReturn(ResponseEntity.ok(new MessageBuilder("There are currently no created users.")));
//        // When and Then
//        mockMvc.perform(get("/api/v1/users"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.message").value("There are currently no created users."));
//    }

    @Test
    void getUserById() {
    }

    @Test
    void deleteUser() {
    }
}