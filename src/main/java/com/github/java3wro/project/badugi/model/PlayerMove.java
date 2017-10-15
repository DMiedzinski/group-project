package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.MoveType;

public class PlayerMove {

    private MoveType moveType;
    private String playerId;
    private long betValue;


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

	public long getBetValue() {
		return betValue;
	}

	public void setBetValue(long betValue) {
		this.betValue = betValue;
	}

	@Override
	public String toString() {
		return "PlayerMove [moveType=" + moveType + ", playerId=" + playerId + ", betValue=" + betValue + "]";
	}
	
	
    
    
}
