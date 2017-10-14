package com.github.java3wro.project.badugi.model;

import com.github.java3wro.project.badugi.enums.Rank;
import com.github.java3wro.project.badugi.enums.Suit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardList;

    private int pointer;


    public void initAndShuffle() {
        cardList = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardList);
        pointer = 51;
    }

    public Card giveOneCard() {
        if (pointer >= 0) {
            pointer--;
            return cardList.remove(0);
        } else {
            Collections.shuffle(cardList);
            pointer = cardList.size() - 1;

            pointer--;
            return cardList.remove(0);
        }

    }

    public void putOneCardOnEnd(Card returningCard) {
        cardList.add(returningCard);
    }

    public Deck() {
    }



    public List<Card> getCardList() {
        return cardList;

    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public void showDeck() {
        for (Card card : cardList) {
            System.out.println(card);
        }
    }


    public String toGson() {
        Gson gson = new GsonBuilder().create();
//        String deckToJson = gson.toJson(this);
        return  gson.toJson(this);
    }

    public Deck fromGson(String deckString) {

        Gson gson = new Gson();
        Deck deck = gson.fromJson(deckString, this.getClass());
        return deck;

    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                ", pointer=" + pointer +
                '}';
    }
}
