package com.github.java3wro.project.game.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by wawat on 05.10.2017.
 */
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long money;

    private String deck;

    @OneToMany(mappedBy = "game")
    private List<Seat> seats;

    @OneToMany(mappedBy = "game")
    private List<Deal> deals;

    public Long getId() {
        return id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}
