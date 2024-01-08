package com.madhu.crud.service;

import com.madhu.crud.dao.UserRepository;
import com.madhu.crud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository=theUserRepository;
    }
    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int theId) {
        return userRepository.findById(theId);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }


}

