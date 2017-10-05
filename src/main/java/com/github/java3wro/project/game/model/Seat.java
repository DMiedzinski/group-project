package com.github.java3wro.project.game.model;

import com.github.java3wro.project.game.enums.Activity;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double money;
    private List<String> cards;
    private User user;
    private Activity activity;
    private Move moves;

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

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public User getUsaer() {
        return user;
    }

    public void setUsaer(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Move getMoves() {
        return moves;
    }

    public void setMoves(Move moves) {
        this.moves = moves;
    }
}
