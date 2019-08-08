package com.gustavodmrl.api.service;

import com.gustavodmrl.api.model.User;


public interface IUserService {

    public User add(User user);
    public Iterable<User> listUsers();
    public User findByUsername(String username);

}
