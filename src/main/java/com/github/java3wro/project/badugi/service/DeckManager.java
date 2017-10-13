package com.github.java3wro.project.badugi.service;

import com.github.java3wro.project.badugi.model.Card;
import com.github.java3wro.project.badugi.model.Deck;
import com.github.java3wro.project.badugi.model.Hand;
import com.github.java3wro.project.badugi.model.Player;

import java.util.ArrayList;
import java.util.List;


public class DeckManager {

    public static List<Hand> dealPlayersHands(List<Player> players, Deck deck) {
        deck = new Deck();
        deck.initAndShuffle();
        List<Hand> hands = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            hands.add(new Hand(DeckManager.dealHand(deck)));
        }
        return hands;
    }


    public static Card exchange(Deck deck, Card card) {

        Card result = deck.giveOneCard();
        deck.putOneCardOnEnd(card);
        return result;
    }

    public static List<Card> dealHand(Deck deck){

        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            hand.add(deck.giveOneCard());
        }
        return hand;

    }



}
