package com.gustavodmrl.api.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_USER")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String userPassword;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin = false;

    @Column(name = "LAST_LOGIN_DATE", nullable = true)
    private LocalDateTime lastLoginDate = null;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;

    public User(String username, String userPassword, String name, String email) {
        this.username = username;
        this.userPassword = userPassword;
        this.name = name;
        this.email = email;
    }

}
