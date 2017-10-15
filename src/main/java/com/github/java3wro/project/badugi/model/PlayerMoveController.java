package com.github.java3wro.project.badugi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.java3wro.project.badugi.enums.MoveType;
//TODO minBet jest zly bo w sytuacji gdy przejdzie jedna kolejka w danejlicytacji to SB musi rzucic min beta a nie moze wyrownac do poziomu aktualnego beta
//dziala sprawdzanie czy jest koniec betowania

public class PlayerMoveController {
	
	public boolean isOverOfBetting(BiddingsOnGame biddingsOnGame, MinBet minBet, List<Player> players) {
		int numberOfPlayers = players.size();
		int bidRound = biddingsOnGame.getBiddingRound();
		int delta = biddingsOnGame.getNumbersOfMove(bidRound) - numberOfPlayers - 1;		
		
		if (delta >= 0) {
			MoveType move;
			PlayerMove playerMove;
			do {
				move =  biddingsOnGame.getCurrentBiddings().getPlayerPreviousMove2(delta);
				playerMove = biddingsOnGame.getCurrentBiddings().get(delta);
				delta++;
			} while (move == MoveType.PASS && delta != biddingsOnGame.getCurrentBiddings().size() - 1);
			if (playerMove.getBetValue() == minBet.getMinBet()) {
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	
	public boolean handleBet(BiddingsOnGame biddingsOnGame, List<Player> players, Player player, PlayerMove playerMove, Pot pot, MinBet minBet) {
		if (validateBet(biddingsOnGame, players, player, playerMove, pot, minBet)) {
			if (isOverOfBetting(biddingsOnGame, minBet, players)) {
				
			} else {
				
			}
		} else {
			
		}
		return true;
	}
	

	public boolean validateBet(BiddingsOnGame biddingsOnGame, List<Player> players, Player player, PlayerMove playerMove, Pot pot, MinBet minBet) {
		if (isValidatePlayerMove(player, playerMove, minBet.getMinBet(), biddingsOnGame, players)) {
			pot.increasePot(playerMove.getBetValue());
			biddingsOnGame.getCurrentBiddings().addPlayerMove(playerMove); 
			System.out.println("player move bet value after validate " + playerMove.getBetValue() );
			minBet.setMinBet(playerMove.getBetValue());
			System.out.println("min bet after move validation " + minBet.getMinBet());
		} else {
			return false;
		}
		return true;
	}

	public boolean isValidatePlayerMove(Player player, PlayerMove playerMove, Long minBet, BiddingsOnGame biddingsOnGame, List<Player> players) {
        if(playerMove.getMoveType().equals(MoveType.WAIT)){
          return canIWait(player, biddingsOnGame, players);        
        } else if (playerMove.getMoveType() == MoveType.PASS){
        	return true;        	
        } else {
        	return playerMove.getBetValue() >= minBet;
        }        
    }

	public boolean canIWait(Player player, BiddingsOnGame biddingsOnGame, List<Player> players) {
		Biddings actualBiddings =  biddingsOnGame.getCurrentBiddings();
    	if (biddingsOnGame.getBiddingRound() == 1) {
    		return false;
    	} else {	
    		if (!(biddingsOnGame.size() > biddingsOnGame.getBiddingRound() - 1)) {
    			return true;
    		} else {
    		
    			for(int i = 0; i < players.size() - 1 && i < biddingsOnGame.getCurrentBiddings().size(); i++) {
    				if (actualBiddings.getPlayerPreviousMove2(actualBiddings.size() - i - 1) != MoveType.WAIT) {
    					return false;
    				}    				    				
    			}    			
    		}    		
    	}
    	return true;		
	}
	
	public static void main(String[] args) {
		Player player1 = new Player();
		player1.setPlayerId("1");
		player1.setGetHays(1000l);
		
		Player player2 = new Player();
		player2.setPlayerId("2");
		player2.setGetHays(1000l);
		
		Player player3 = new Player();
		player3.setPlayerId("3");
		player3.setGetHays(1000l);
		
		List<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		List<Biddings> biddingsList = new ArrayList<>();
		Biddings biddings = new Biddings();
		PlayerMove playerMove = new PlayerMove();
		playerMove.setPlayerId("1");
		playerMove.setBetValue(10l);
		playerMove.setMoveType(MoveType.SB);
		PlayerMove playerMove2 =  new PlayerMove();
		playerMove2.setPlayerId("2");
		playerMove2.setBetValue(20l);
		playerMove2.setMoveType(MoveType.BB);
		biddings.addPlayerMove(playerMove);
		biddings.addPlayerMove(playerMove2);
		biddingsList.add(biddings);
		Pot pot = new Pot();
		pot.setPot(30l);
		int biddingRound = 1;
		MinBet minBet = new MinBet();
		minBet.setMinBet(20);
		BiddingsOnGame biddingsOnGame = new BiddingsOnGame();
		biddingsOnGame.setBiddingRound(biddingRound);
		biddingsOnGame.setBiddings(biddingsList);
		
		
		Scanner input = new Scanner(System.in);

		
		PlayerMoveController playerMoveController = new PlayerMoveController();
		for (int i = 0; i < 15; i++) {
			System.out.println("--------------------------------------------");
			System.out.println("actual players moves list");
			biddingsOnGame
			.getCurrentBiddings()
			.getPlayersMoves()
			.stream()
			.forEach(System.out::println);


			System.out.println("Pot " + pot);
			System.out.println("minBet " + minBet.getMinBet());
			System.out.println("player " + players.get((i + 2) % 3).getPlayerId());
			System.out.println("podaj odzywke");
			String type = input.nextLine();
			MoveType move = MoveType.getEnum(type);
			System.out.println("podaj beta");
			Long bet = input.nextLong();
			PlayerMove moveTemp = new PlayerMove();
			moveTemp.setPlayerId(players.get((i + 2) % 3).getPlayerId());
			moveTemp.setMoveType(move);
			moveTemp.setBetValue(bet);
			input.nextLine();
			
			System.out.println(playerMoveController.validateBet(biddingsOnGame, players, players.get((i + 2) % 3), moveTemp, pot, minBet));
			System.out.println("is over betting");
			System.out.println(playerMoveController.isOverOfBetting(biddingsOnGame, minBet, players));
			System.out.println("----------------------------------");
		}
		
		
	}
	
	
}
   
    
