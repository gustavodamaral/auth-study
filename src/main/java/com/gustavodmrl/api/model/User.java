package com.gustavodmrl.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER")
@Data
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @Column(name = "ID_USER")
    private Long id;

    private String username;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    private String name;

    private String email;

    @Column(name = "LAST_LOGIN_DATE")
    private LocalDateTime lastLoginDate;

}
