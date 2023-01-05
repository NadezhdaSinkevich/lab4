package by.application.javaWeb.service;

import by.application.javaWeb.model.entity.User;
import by.application.javaWeb.repository.impl.UserRepositoryImpl;

import java.util.Optional;

public class UserService {

    private UserRepositoryImpl userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryImpl();
    }

    public Optional<User> isExistsUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
//        Optional<User> optional = userRepository.findByLoginAndPassword(login, password);
//        return optional.isPresent();
    }

    public void login(Integer userId) {
        Integer accessModeId = 1;
        userRepository.update(userId, accessModeId);
    }

    public void logout(Integer userId) {
        Integer accessModeId = 0;
        userRepository.update(userId, accessModeId);
    }

}
