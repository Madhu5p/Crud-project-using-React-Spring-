package com.madhu.crud.controller;

import com.madhu.crud.exception.UserNotFoundException;
import com.madhu.crud.model.User;
import com.madhu.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService theUserService){
        userService=theUserService;
    }
    @GetMapping("/users")
    public List<User> findALl(){
        return userService.findAll();
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User theUser){
        theUser.setId(0);
        User dbUser=userService.save(theUser);
        return dbUser;
    }
    @GetMapping("/user/{id}")
   public Optional<User> finById(@PathVariable int id){
        return Optional.ofNullable(userService.findById(id)
                .orElseThrow(() -> new UserNotFoundException(Math.toIntExact(id))));
    }
    @PutMapping("/user/{id}")
    public Optional<User> updateUser(@RequestBody User theUser, @PathVariable int id){

        return Optional.ofNullable(userService.findById(id)
                .map(user -> {
                    user.setUserName(theUser.getUserName());
                    user.setEmail(theUser.getEmail());
                    user.setPhoneNumber(theUser.getPhoneNumber());
                    return userService.save(user);
                }).orElseThrow(() -> new UserNotFoundException(Math.toIntExact(id))));
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteById(id);
        return "Deleted Successfully";

    }
}
