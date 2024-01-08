package com.madhu.crud.dao;

import com.madhu.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    void deleteById(User theId);
}
