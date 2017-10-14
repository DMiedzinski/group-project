package com.github.java3wro.project.game.controller;

import com.github.java3wro.project.game.model.Game;
import com.github.java3wro.project.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by wawat on 14.10.2017.
 */
@RestController
@RequestMapping("/game/api")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @RequestMapping("/findone")
    public Game findOne() {
        return gameRepository.findOneByOrOrderByCreatedOnDesc();
    }
}
