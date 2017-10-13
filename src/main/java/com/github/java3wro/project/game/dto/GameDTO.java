package com.github.java3wro.project.game.dto;

import com.github.java3wro.project.game.model.Deal;
import com.github.java3wro.project.game.model.Seat;


import java.util.List;

/**
 * Created by wawat on 11.10.2017.
 */
public class GameDTO {

    private String deck;
    private List<Seat> seats;
    private List<Deal> deals;

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }
}
