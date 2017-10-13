package com.github.java3wro.project.game;

import com.github.java3wro.project.badugi.model.Deck;
import com.github.java3wro.project.badugi.model.Pool;
import com.github.java3wro.project.badugi.model.Users;

import java.util.List;

public class NewGame {
    private List<Users> palyers;
    private List<Deck> decks;
    private Deck gameDeck;
    private Pool gamePool;


    public NewGame(List<Users> palyers, List<Deck> decks, Deck gameDeck, Pool gamePool) {
        this.palyers = palyers;
        this.decks = decks;
        this.gameDeck = gameDeck;
        this.gamePool = gamePool;
    }

    public List<Users> getPalyers() {
        return palyers;
    }

    public void setPalyers(List<Users> palyers) {
        this.palyers = palyers;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    public void setGameDeck(Deck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public Pool getGamePool() {
        return gamePool;
    }

    public void setGamePool(Pool gamePool) {
        this.gamePool = gamePool;
    }

}
