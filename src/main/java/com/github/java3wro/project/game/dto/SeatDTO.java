package com.github.java3wro.project.game.dto;


/**
 * Created by wawat on 10.10.2017.
 */
public class SeatDTO {

    private String cards;
    private String user;
    private double money;
    private boolean isActive;

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
