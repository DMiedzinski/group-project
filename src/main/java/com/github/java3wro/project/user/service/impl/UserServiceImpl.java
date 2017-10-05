package com.github.java3wro.project.user.service.impl;

import com.github.java3wro.project.user.dto.UserDto;
import com.github.java3wro.project.user.model.User;
import com.github.java3wro.project.user.repository.UserRepository;
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

    @Override
    public User create(UserDto userDto) {
        User old = userRepository.findByUsername(userDto.getUsername());
        if (old != null) {
            throw new RuntimeException();
        }
        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            throw new RuntimeException();
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);

    }
}
