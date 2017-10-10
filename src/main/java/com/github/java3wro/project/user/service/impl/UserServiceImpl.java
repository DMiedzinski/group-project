package com.github.java3wro.project.user.service.impl;

import com.github.java3wro.project.user.dto.UserDto;
import com.github.java3wro.project.user.model.Token;
import com.github.java3wro.project.user.model.User;
import com.github.java3wro.project.user.repository.TokenRepository;
import com.github.java3wro.project.user.repository.UserRepository;
import com.github.java3wro.project.user.service.EmailService;
import com.github.java3wro.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public User create(UserDto userDto) {
        User old = userRepository.findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail());
        if (old != null) {
            throw new RuntimeException("Username already in use");
        }
        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            throw new RuntimeException("Password does not match");
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setEnable(false);
        user = userRepository.save(user);

        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setUserId(user.getId());
        token = tokenRepository.save(token);

        emailService.sendEmail(user.getEmail(), token.getToken());

        return user;
    }

    @Override
    public void unlocking(String s) {
        Token token = tokenRepository.findOneByToken(s);
        User user = userRepository.getOne(token.getUserId());
        user.setEnable(true);
        userRepository.save(user);
        return;
    }


}
