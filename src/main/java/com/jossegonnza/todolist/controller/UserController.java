package com.jossegonnza.todolist.controller;

import com.jossegonnza.todolist.entity.UserEntity;
import com.jossegonnza.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        // Aquí deberías verificar las credenciales del usuario.
        // Por simplicidad, este ejemplo asume que las credenciales son correctas.
        return new ModelAndView("redirect:/categories/home");
    }


}
