package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.exceptions.FullGameException;
import com.github.java3wro.project.game.model.Deal;
import com.github.java3wro.project.game.model.Seat;
import com.github.java3wro.project.game.model.Game;
import com.github.java3wro.project.game.repository.DealRepository;
import com.github.java3wro.project.game.repository.GameRepository;
import com.github.java3wro.project.game.service.DealService;
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
    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private DealService dealService;


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

    @Override
    public Game joinGame(String user) {
        List<Game> games = gameRepository.findAll();
        for (Game game : games) {
            int factor = 0;
            boolean sitDown = false;

            while (sitDown == false) {
                for (Seat seat : game.getSeats()) {
                    if (seat.getUser().equals("")) {
                        seat.setUser(user);
                        gameRepository.save(game);
                        sitDown = true;
                    }
                    factor++;
                }
            }
            if (factor > 3) {
                Deal deal = dealService.getLastDeal(game);
                if (deal.isFinished() || deal == null) {
                    deal = dealService.createDeal(game);
                    game.addDeal(deal);
                }
            }
            if (sitDown == true) {
                return game;
            }
        }
        throw new FullGameException();
    }
}
