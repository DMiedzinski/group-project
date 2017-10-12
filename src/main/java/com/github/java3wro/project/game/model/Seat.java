package com.github.java3wro.project.game.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double money;
    private String user;
    private String cards;
    private boolean isActive;
    private String yourTurn;

    @OneToMany(mappedBy = "seat")
    private List<Move> moves;

    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;

    @ManyToMany
    private List<Deal> deals;

    public String getYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(String yourTurn) {
        this.yourTurn = yourTurn;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}



