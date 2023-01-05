package by.application.javaWeb.repository;

import by.application.javaWeb.model.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByLoginAndPassword(String login, String password);
    void update(Integer userId, Integer accessModeId);
}
