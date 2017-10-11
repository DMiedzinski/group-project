package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.model.Seat;
import com.github.java3wro.project.game.model.Game;
import com.github.java3wro.project.game.repository.GameRepository;
import com.github.java3wro.project.game.service.GameService;
import com.github.java3wro.project.game.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private SeatService seatService;



    @Override
    public Game createGame() {
        Game game = new Game();
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            seats.add(seatService.createSeat());
        }
        game.setSeats(seats);
        game = gameRepository.save(game);
        return game;
    }



}
