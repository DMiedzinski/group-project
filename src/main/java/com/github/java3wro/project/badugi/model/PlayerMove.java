package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.MoveType;

public class PlayerMove {

    MoveType moveType;
    private String playerId;


    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
