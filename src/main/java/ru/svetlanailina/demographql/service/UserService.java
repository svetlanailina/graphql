package ru.svetlanailina.demographql.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.svetlanailina.demographql.model.User;

import java.util.*;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Generate test users
        users.add(new User(UUID.randomUUID().toString(), "Alice", 30));
        users.add(new User(UUID.randomUUID().toString(), "Bob", 25));
        users.add(new User(UUID.randomUUID().toString(), "Charlie", 35));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User createUser(String name, int age) {
        User user = new User(UUID.randomUUID().toString(), name, age);
        users.add(user);
        return user;
    }


}
