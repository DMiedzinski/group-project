package com.github.java3wro.project.badugi.model;

import java.util.ArrayList;
import java.util.List;

import com.github.java3wro.project.badugi.enums.MoveType;

public class Biddings {

    private List<PlayerMove> playersMoves;


    public Biddings() {
        this.playersMoves = new ArrayList<>();
    }
    
    public int size() {
    	return playersMoves.size();
    }
    
    public PlayerMove get(int index) {
    	return playersMoves.get(index);
    }
    
    


    public void addPlayerMove(PlayerMove playerMove) {
        playersMoves.add(playerMove);
    }

    public MoveType getPlayerPreviousMove(String playerId) {
    	int index = indexOfPreviousPlayerMove(playerId);
    	return playersMoves.get(index).getMoveType();    	
    }
    
    public MoveType getPlayerPreviousMove2(int index) {
    	return playersMoves.get(index).getMoveType();
    }

    public int indexOfPreviousPlayerMove(String playerId) {
        for (int i = playersMoves.size(); i >= 0; i++) {
            if (playersMoves.get(i).getPlayerId().equals(playerId)) {
                return i;
            }
        } return -1;
    }
    
    
    
    public List<PlayerMove> getPlayersMoves() {
		return playersMoves;
	}

	public void setPlayersMoves(List<PlayerMove> playersMoves) {
		this.playersMoves = playersMoves;
	}

	public int numbersOfMoves() {
    	return playersMoves.size();
    }
}
