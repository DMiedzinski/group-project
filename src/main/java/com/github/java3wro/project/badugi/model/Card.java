package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.Rank;
import com.github.java3wro.project.badugi.enums.Suit;

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

    @Override
    public int compareTo(Card card) {
        return this.getCardColors().compareTo(card.getCardColors());
    }
}
