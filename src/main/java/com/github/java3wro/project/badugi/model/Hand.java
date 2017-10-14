package com.github.java3wro.project.badugi.model;

import java.util.Comparator;
import java.util.List;

public class Hand {

    List<Card> cardsOnHand;

    public List<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public void setCardsOnHand(List<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void sortHand() {
        cardsOnHand.sort(Comparator.comparing(Card::getCardColors));
    }

    public void showHand() {
        cardsOnHand
                .stream()
                .forEach(System.out::println);
    }
}

