package com.jossegonnza.todolist.controller;

import com.jossegonnza.todolist.entity.UserEntity;
import com.jossegonnza.todolist.exceptions.UserNotExist;
import com.jossegonnza.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/swagger-ui/index.html SWAGGER

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public void register(@RequestBody UserEntity user) {
        userService.createUser(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public void loginUser(@RequestBody UserEntity user) {
        userService.getUserByUsername(user.getUsername()).orElseThrow(() -> new UserNotExist("User no existe"));
    }


}
