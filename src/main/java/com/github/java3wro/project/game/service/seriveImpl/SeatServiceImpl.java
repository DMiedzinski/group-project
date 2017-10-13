package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.model.Move;
import com.github.java3wro.project.game.model.Seat;
import com.github.java3wro.project.game.repository.SeatRepository;
import com.github.java3wro.project.game.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wawat on 06.10.2017.
 */
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seat createSeat() {
        Seat seat = new Seat();
        seat.setMoney(1000);
        seat.setActive(false);
        seat.setUser("");
        seat.setYourTurn("");
        seat = seatRepository.save(seat);

        return seat;
    }
}
