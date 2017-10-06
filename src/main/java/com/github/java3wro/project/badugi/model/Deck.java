package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.Rank;
import com.github.java3wro.project.badugi.enums.Suit;

import java.util.*;

public class Deck {

    private List<Card> cardList;

    public void deckInit() {
        cardList = new ArrayList<Card>() {
        };
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardList);
        cardList.forEach(System.out::println);
        System.out.println("-----------------------------");
        sortDeck();
        cardList.forEach(System.out::println);

    }

    public Card giveOneCard() {
        Card cardTaken = cardList.get(0);
        cardList.remove(0);
        return cardTaken;
    }

    public void sortDeck() {

        cardList.sort(Comparator.comparing(Card::getCardColors));
    }

    public void putOneCardOnEnd(Card returnigCard) {
        cardList.add(cardList.size(), returnigCard);
    }

    public void printList(){

    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.deckInit();

    }
}
