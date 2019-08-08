package com.gustavodmrl.api.controller;

import com.gustavodmrl.api.dto.UserDataDTO;
import com.gustavodmrl.api.model.User;
import com.gustavodmrl.api.exception.ServiceException;
import com.gustavodmrl.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "User")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    protected UserService userService;

    @ApiOperation(nickname = "listUsers", value = "")
    @GetMapping
    public HttpEntity<Iterable<User>> listUsers() {

        try {
            Iterable<User> userList = userService.listUsers();
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "Nenhum usuário encontrado!");
        }


    }

    @ApiOperation(nickname = "addUser", value = "")
    @PostMapping
    public HttpEntity<User> add(@RequestBody UserDataDTO user) {

        try {
            return ResponseEntity.ok(userService.add(user.transferToObj()));
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Falha ao cadastrar usuário");
        }

    }

}
