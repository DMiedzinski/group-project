package com.github.java3wro.project.badugi.model;

import java.util.ArrayList;
import java.util.List;

public class Biddings {

    private List<PlayerMove> playerMoves;


    public Biddings() {
        this.playerMoves = new ArrayList<>();
    }


    public void addPlayerMove(PlayerMove playerMove) {
        playerMoves.add(playerMove);
    }

//    public MoveType getPlayerPreviousMove(String playerId) {
//
//
//    }

    public int dupa(String playerId) {
        for (int i = playerMoves.size(); i >= 0; i++) {
            if (playerMoves.get(i).getPlayerId().equals(playerId)) {
                return i;
            }
        } return -1;
    }

}
