package com.github.java3wro.project;

import com.github.java3wro.project.game.model.Game;
import com.github.java3wro.project.game.service.DealService;
import com.github.java3wro.project.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    GameService gameService;
    @Autowired
    DealService dealService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
    Game game = gameService.createGame();
    dealService.createDeal(game);
    }
}
