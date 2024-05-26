package com.javatech.practicerecords.service;

import com.javatech.practicerecords.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers();
    public Optional<User> getUserById(int id);
    public User addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User getUserByName(String name);
}
