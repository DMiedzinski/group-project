package com.github.java3wro.project.badugi.service;

import com.github.java3wro.project.badugi.model.Card;
import com.github.java3wro.project.badugi.model.Deck;
import com.github.java3wro.project.badugi.model.Hand;

import java.util.ArrayList;
import java.util.List;

public class WhoWin {


    public static List<Integer> checkWhoWin(List<Hand> hands1){
        List<Integer> winners= new ArrayList<>();

        System.out.println("------------------------------------------------------");


        for(Hand hand: hands1) {
            CheckerHand.checkHandsPlayer(hand);
        }



        hands1.stream().forEach(hand -> {
            System.out.println("\n hands after checcker \n");
            System.out.println(hand);
        });
        System.out.println("------------------------------------------------------------");

        int tempWinner = 0;
        for (int i = 1; i < hands1.size(); i++) {
            if (hands1.get(tempWinner).getCardsOnHand().size() == hands1.get(i).getCardsOnHand().size()) {
                if (hands1.get(tempWinner).max().compareTo(hands1.get(i).max()) == 0) {
                    winners.add(i);
                } else if (hands1.get(tempWinner).max().compareTo(hands1.get(i).max()) > 0) {
                    winners.clear();
                    tempWinner = i;
                }
            } else if (hands1.get(tempWinner).getCardsOnHand().size() < hands1.get(i).getCardsOnHand().size()) {
                tempWinner = i;
                winners.clear();
            }
        }
        winners.add(tempWinner);

        return winners;
    }

//    public static void main(String[] args) {
//        Deck deck = new Deck();
//        deck.deckInitandShuffle();
//
//        List<Hand> hands = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//            List<Card> cards1 = new ArrayList<>();
//
//            for (int j = 0; j < 4; j++) {
//                cards1.add(deck.giveOneCard());
//            }
//            hands.add(new Hand(cards1));
//
//        }
//
//        hands.stream().forEach(hand -> {
//            System.out.println("\n hands in game \n");
//            System.out.println(hand);
//        });
//
//        System.out.println("Our winners: ");
//        checkWhoWin(hands).stream().forEach(System.out::println);
//
//    }



}
