package com.gustavodmrl.api.repository;

import com.gustavodmrl.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
}
