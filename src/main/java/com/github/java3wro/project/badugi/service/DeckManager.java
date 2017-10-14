package com.github.java3wro.project.badugi.service;

import com.github.java3wro.project.badugi.model.Card;
import com.github.java3wro.project.badugi.model.Deck;
import com.github.java3wro.project.badugi.model.Hand;
import com.github.java3wro.project.badugi.model.Player;
import com.github.java3wro.project.game.model.Seat;

import java.util.ArrayList;
import java.util.List;


public class DeckManager {

    public static List<Hand> dealPlayersHands(List<Seat> players, Deck deck) {
        deck = new Deck();
        deck.initAndShuffle();
        List<Hand> hands = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            hands.add(new Hand(DeckManager.dealHand(deck)));
        }
        return hands;
    }


    public static List<Card> exchange(Deck deck, List<Card> cards) {
        List<Card> exchangedCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            exchangedCards.add(deck.giveOneCard());
            deck.putOneCardOnEnd(cards.get(i));
        }
        return exchangedCards;
    }

    public static List<Card> dealHand(Deck deck){

        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            hand.add(deck.giveOneCard());
        }
        return hand;

    }



}
