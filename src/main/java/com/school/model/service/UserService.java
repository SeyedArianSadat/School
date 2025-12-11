package com.school.model.service;

import com.school.model.entity.Student;
import com.school.model.entity.User;
import com.school.model.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    public void save(User user) throws Exception {
        UserRepository userRepository = new UserRepository();
        userRepository.save(user);
    }
    public void update(User user) throws Exception {
        UserRepository userRepository = new UserRepository();
        userRepository.update(user);
    }
    public void deleteById(Long id) throws Exception {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteById(id);
    }
    public Optional<User> findById(Long id) throws Exception {
        UserRepository userRepository = new UserRepository();
        return userRepository.findById(id);
    }
    public List<User> findAll() throws Exception {
        UserRepository userRepository = new UserRepository();
        return userRepository.findAll();
    }
    public Optional<User> findByUsername(String username) throws Exception {
        UserRepository userRepository = new UserRepository();
        return userRepository.findByUsername(username);
    }
}
