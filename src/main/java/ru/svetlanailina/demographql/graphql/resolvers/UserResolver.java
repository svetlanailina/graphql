package ru.svetlanailina.demographql.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.svetlanailina.demographql.model.User;
import ru.svetlanailina.demographql.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
/*
Когда сервер GraphQL получает запрос, он разбивает его на отдельные поля
 и вызывает соответствующие резолверы для каждого поля.
 Резолверы затем выполняют свою работу и возвращают данные,
 которые сервер GraphQL собирает в ответ и отправляет клиенту

 Resolver: Класс UserResolver содержит метод getUser,
 который выполняет логику поиска пользователя по id
 и выбрасывает исключение, если пользователь не найден.
 */
@Component
public class UserResolver {
    /*
    private List<User> users = List.of(
            new User("1", "John Doe", 21),
            new User("2", "Jane Doe", 22)
    );

    public User getUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

     */
    @Autowired
    private UserService userService;

    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    public User getUser(String id) {
        return userService.getUserById(id).orElse(null);
    }

    public User createUser(String name, int age) {
        return userService.createUser(name, age);
    }
}
