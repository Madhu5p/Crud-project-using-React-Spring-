package com.madhu.crud.service;

import com.madhu.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User theUser);
    List<User> findAll();
    Optional<User> findById(int theId);
    void deleteById(int theId);

}
