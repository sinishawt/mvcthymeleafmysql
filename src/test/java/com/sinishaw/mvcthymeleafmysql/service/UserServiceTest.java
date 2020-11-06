package com.sinishaw.mvcthymeleafmysql.service;

import com.sinishaw.mvcthymeleafmysql.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void listAllUsers() {

        User user1 = new User(555,"ds", "ds");
        User user2 = new User(555,"ds", "ds");

        userService.addUser(user1);
        userService.addUser(user2);

        List<User> users = userService.listAllUsers();

        assertEquals(2, users.size());
    }

    @Test
    void findUserById() {
    }

    @Test
    void addUser() {
    }

    @Test
    void delete() {
    }

    @Test
    void saveAll() {

        User user1 = new User(122,"ds", "ds");
        User user2 = new User(555,"ds", "ds");
        User user3 = new User(32,"abebe", "gle");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        userService.saveAll(users);

        assertEquals(3, userService.listAllUsers().size());
    }
}