package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.Suit;
import com.github.java3wro.project.badugi.enums.Rank;

public class Card implements Comparable<Card>{
    public Card() {
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private Suit suit;
    private Rank rank;

    public Suit getCardColors() {
        return suit;
    }

    public void setCardColors(Suit cardColors) {
        this.suit = cardColors;
    }

    public Rank getCardFigures() {
        return rank;
    }

    public void setCardFigures(Rank cardFigures) {
        this.rank = cardFigures;
    }

    @Override
    public String toString() {
        return rank + " of "+ suit;
    }


    public static void main(String[] args) {
        Card card = new Card(Suit.CLUBS,Rank.EIGHT);
        Card card1 = new Card(Suit.DIAMONDS, Rank.EIGHT);
        Card card2 = new Card(Suit.CLUBS,Rank.EIGHT);
        System.out.println(card1.compareTo(card2));
        System.out.println(card2.compareTo(card));
        System.out.println(card2.compareTo(card1));
    }

    @Override
    public int compareTo(Card card) {
        return this.getCardColors().compareTo(card.getCardColors());
    }
}
