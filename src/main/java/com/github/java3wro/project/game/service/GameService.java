package com.github.java3wro.project.game.service;


import com.github.java3wro.project.game.model.Game;

public interface GameService {

    Game createGame();

    Game joinGame(String user);
}
