package ru.svetlanailina.demographql.graphql.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.svetlanailina.demographql.model.User;
import ru.svetlanailina.demographql.service.UserService;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @QueryMapping
    public User getUserById(@Argument String id) {
        return userService.getUserById(id).orElse(null);
    }

    @CrossOrigin
    @MutationMapping
    public User createUser(@Argument String name, @Argument int age) {
        return userService.createUser(name, age);
    }
}