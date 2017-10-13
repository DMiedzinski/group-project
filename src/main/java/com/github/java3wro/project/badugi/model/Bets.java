package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.PlayerDecisions;

public class Bets implements Comparable<PlayerDecisions>{

 private PlayerDecisions playerDecisions;

 public Bets(PlayerDecisions playerDecisions){
     return;
 }

    public PlayerDecisions getPlayerDecisions() {
        return playerDecisions;
    }

    public void setPlayerDecisions(PlayerDecisions playerDecisions) {
        this.playerDecisions = playerDecisions;
    }

    @Override
    public String toString() {
        return "Bets{" +
                "playerDecisions=" + playerDecisions +
                '}';
    }

    @Override
    public int compareTo(PlayerDecisions o) {
        return 0;
    }
}
