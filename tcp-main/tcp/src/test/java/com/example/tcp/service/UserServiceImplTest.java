package com.example.tcp.service;

import com.example.tcp.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(UserServiceImpl.class)
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void getUsers() {
        List<UserDTO> users = userService.getUsers();
        assertNotNull(users);
    }

    @Test
    void getUserById() {
        UserDTO user = userService.getUserById(4);
        assertNotNull(user);
    }

    @Test
    void getUserByNationalCode() {
        UserDTO user = userService.getUserByNationalCode(7547567824L);
        assertNotNull(user);
    }

    @Test
    void existsUserByNationalCode() {
        boolean exists = userService.existsUserByNationalCode(7547567824L);
        assertTrue(exists);
    }
}