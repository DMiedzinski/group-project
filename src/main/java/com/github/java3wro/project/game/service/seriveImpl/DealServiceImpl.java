package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.badugi.model.Deck;
import com.github.java3wro.project.badugi.model.Hand;
import com.github.java3wro.project.badugi.service.DeckManager;
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
        dealCards(game);

        deal = dealRepository.save(deal);

        return deal;
    }

    @Override
    public Deal getLastDeal (Game game){
        return dealRepository.findOneByGameIdOrderByCreatedOnDesc(game.getId());
    }

    @Override
    public void dealCards(Game game){
        Deck deck = new Deck();
        List<Seat> seats = game.getSeats();

        List <Hand> hands = DeckManager.dealPlayersHands(game.getSeats(), deck);
        for (int i = 0; i < seats.size(); i++){
            Seat seat = seats.get(i);
            seat.setCards(hands.get(i).toString());
        }
        String cards = deck.toGson();
        game.setDeck(cards);
    }
}
