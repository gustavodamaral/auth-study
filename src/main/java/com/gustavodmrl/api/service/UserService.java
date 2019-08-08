package com.gustavodmrl.api.service;

import com.gustavodmrl.api.model.User;
import com.gustavodmrl.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User add(User user) {

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        return userRepository.save(user);
    }

    @Override
    public Iterable<User> listUsers() {

        try {
            Iterable<User> users = userRepository.findAll();

            users.forEach(u -> System.out.println(u.getEmail()));

        } catch (Exception e) {
            e.getMessage();
        }

        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
