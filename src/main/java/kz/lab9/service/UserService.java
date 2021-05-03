package kz.lab9.service;

import kz.lab9.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
}
