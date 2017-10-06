package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.Rank;
import com.github.java3wro.project.badugi.enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public static List<Integer> checkWinnerAndRewards(List<Hand> playersHands) {
        List<Integer> rewards = new ArrayList<>();


        playersHands
                .stream()
                .peek(Hand::sortHand)
                .forEach(Hand::showHand);

        return rewards;
    }

    public static void main(String[] args) {
        Hand hand = new Hand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));

        cards.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.JACK));
        hand.setCardsOnHand(cards);

        List<Hand> hands = new ArrayList<>();
        hands.add(hand);
         checkWinnerAndRewards(hands);
    }



}
