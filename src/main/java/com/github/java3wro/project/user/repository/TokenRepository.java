package com.github.java3wro.project.user.repository;

import com.github.java3wro.project.user.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findOneByToken(String token);
}
