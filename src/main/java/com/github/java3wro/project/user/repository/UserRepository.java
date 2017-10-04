package com.github.java3wro.project.user.repository;

import com.github.java3wro.project.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String user);
}
