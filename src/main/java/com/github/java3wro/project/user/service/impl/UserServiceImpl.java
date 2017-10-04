package com.github.java3wro.project.user.service.impl;

import com.github.java3wro.project.user.model.User;
import com.github.java3wro.project.user.repository.UserRepository;
import com.github.java3wro.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return null;
    }
}
