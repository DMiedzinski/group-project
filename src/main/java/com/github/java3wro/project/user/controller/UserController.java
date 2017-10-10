package com.github.java3wro.project.user.controller;

import com.github.java3wro.project.user.dto.ResetPasswordDto;
import com.github.java3wro.project.user.dto.UserDto;
import com.github.java3wro.project.user.model.Token;
import com.github.java3wro.project.user.model.User;
import com.github.java3wro.project.user.repository.TokenRepository;
import com.github.java3wro.project.user.repository.UserRepository;
import com.github.java3wro.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/register")
    public User createUser(@Valid UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/{token}")
    public void confirmEmail(@PathVariable String token) {
        userService.unlocking(token);
    }

    @GetMapping("/recovery/{username}")
    public void recoveryEmail(@PathVariable String username) { userService.recoveryPassword(username);}

    @PostMapping("/recovery/reset")
    public void newPassword(@Valid ResetPasswordDto resetPasswordDto) {userService.newPassword(resetPasswordDto);}


}
