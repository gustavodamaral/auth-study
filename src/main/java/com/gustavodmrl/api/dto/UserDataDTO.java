package com.gustavodmrl.api.dto;

import com.gustavodmrl.api.model.User;
import lombok.Getter;

@Getter
public class UserDataDTO {

    private String username;
    private String userPassword;
    private String name;
    private String email;

    public User transferToObj() {
        return new User(username, userPassword, name, email);
    }

}
