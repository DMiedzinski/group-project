package com.github.java3wro.project.user.controller;

import com.github.java3wro.project.user.dto.UserDto;
import com.github.java3wro.project.user.model.User;
import com.github.java3wro.project.user.repository.UserRepository;
import com.github.java3wro.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public User createUser(@RequestBody @Valid UserDto userDto) {
        return userService.create(userDto);
    }
}
