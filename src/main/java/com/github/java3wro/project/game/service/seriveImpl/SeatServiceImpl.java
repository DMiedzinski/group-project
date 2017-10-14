package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.model.Game;
import com.github.java3wro.project.game.model.Seat;
import com.github.java3wro.project.game.repository.SeatRepository;
import com.github.java3wro.project.game.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wawat on 06.10.2017.
 */
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seat createSeat(Game game) {
        Seat seat = new Seat();
        seat.setMoney(1000);
        seat.setActive(false);
        seat.setUser("");
        seat.setYourTurn("");
        seat.setGame(game);
        seat = seatRepository.save(seat);

        return seat;
    }
}
