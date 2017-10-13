package com.github.java3wro.project.badugi.model;

import java.util.List;

public class Users {

    private List<Hand> userHands;
    private Bets userBets;

    public Users() {
    }

    public Users(List<Hand> userHands, Bets userBets) {
        this.userHands = userHands;
        this.userBets = userBets;
    }

    public List<Hand> getUserHands() {
        return userHands;
    }

    public void setUserHands(List<Hand> userHands) {
        this.userHands = userHands;
    }

    public Bets getUserBets() {
        return userBets;
    }

    public void setUserBets(Bets userBets) {
        this.userBets = userBets;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userHands=" + userHands +
                ", userBets=" + userBets +
                '}';
    }
}
