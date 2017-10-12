package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.model.Deal;
import com.github.java3wro.project.game.model.Game;
import com.github.java3wro.project.game.model.Seat;
import com.github.java3wro.project.game.repository.DealRepository;
import com.github.java3wro.project.game.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wawat on 10.10.2017.
 */
@Service
public class DealServiceImpl implements DealService {

    @Autowired
    DealRepository dealRepository;

    @Override
    public Deal createDeal(Game game) {
        Deal deal = new Deal();
        deal.setGame(game);
        List <Seat> seats = game.getSeats();

        for (Seat seat:seats) {
            if (seat.getUser() != null)seat.setActive(true);
        }

        deal.setSeats(game.getSeats());
        deal = dealRepository.save(deal);

        return deal;
    }
}
