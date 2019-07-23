package com.gustavodmrl.api.controller;

import com.gustavodmrl.api.model.User;
import com.gustavodmrl.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(value = "User")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    protected UserService userService;

    @ApiOperation(nickname = "listUsers", value = "")
    @GetMapping
    public Iterable<User> listUsers() {

        return userService.listUsers();

    }

    @ApiOperation(nickname = "addUser", value = "")
    @PostMapping
    public User add(@RequestBody User user) {

        return userService.add(user);

    }

}
