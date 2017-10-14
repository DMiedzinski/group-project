package com.github.java3wro.project.badugi.model;

import java.util.Comparator;
import java.util.List;

public class Hand {

    private List<Card> cardsOnHand;

    public Hand() {
    }

    public Hand(List<Card> cards) {
        this.cardsOnHand = cards;
    }

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


    public Card max() {
        Card card = cardsOnHand.get(0);
        for (int i = 1; i < cardsOnHand.size(); i++) {
            if (card.getCardFigures().compareTo(cardsOnHand.get(i).getCardFigures()) < 0) {
                card = cardsOnHand.get(i);
            }
        }
        return card;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cardsOnHand=" + cardsOnHand +
                '}';
    }
}

