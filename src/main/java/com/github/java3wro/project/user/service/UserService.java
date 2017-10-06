package com.github.java3wro.project.user.service;

import com.github.java3wro.project.user.dto.UserDto;
import com.github.java3wro.project.user.model.Token;
import com.github.java3wro.project.user.model.User;

public interface UserService {

    User create(UserDto userDto);
    void unlocking(String s);
}
