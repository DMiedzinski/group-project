package com.github.java3wro.project.badugi.service;

import com.github.java3wro.project.badugi.enums.Rank;
import com.github.java3wro.project.badugi.model.Card;
import com.github.java3wro.project.badugi.model.Deck;
import com.github.java3wro.project.badugi.model.Hand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckerHand {




    public static void checkHandsPlayer(Hand hand) {

        hand.sortHand();
//        System.out.println("\n sorted");
//        hand.getCardsOnHand().stream().forEach(System.out::println);
        for (int i = 0; i < hand.getCardsOnHand().size() - 1; i++) {
            if (hand.getCardsOnHand().get(i).getCardColors().equals(hand.getCardsOnHand().get(i + 1).getCardColors())) {
                if (!isUniqCard(hand.getCardsOnHand(), i)) {
                    hand.getCardsOnHand().remove(i);
                } else if (!isUniqCard(hand.getCardsOnHand(), i + 1)) {
                    hand.getCardsOnHand().remove(i + 1);
                } else {
                    int checkMin = hand.getCardsOnHand().get(i).getCardFigures().compareTo(hand.getCardsOnHand().get(i + 1).getCardFigures());
                    if (checkMin < 0) {
                        hand.getCardsOnHand().remove(i + 1);
                    } else {
                        hand.getCardsOnHand().remove(i);
                    }
                }
                i--;
            }
        }

//        System.out.println("\n removed");
//        hand.getCardsOnHand().stream().forEach(System.out::println);

        for (int i = 0; i < hand.getCardsOnHand().size() ; i++) {
//            System.out.println("\n  is unique " + isUniqCard(hand.getCardsOnHand(), i));
            if (!isUniqCard(hand.getCardsOnHand(), i)) {

                hand.getCardsOnHand().remove(i);
            }
        }

//        System.out.println("\n unique");
//        hand.getCardsOnHand().stream().forEach(System.out::println);
    }

    public static boolean isUniqCard(List<Card> listToCheck, int index) {

        List<Rank> ranks = listToCheck
                .stream()
                .map(card -> card.getCardFigures())
                .filter(figure -> listToCheck.get(index).getCardFigures().equals(figure))
                .collect(Collectors.toList());
        return ranks.size() >= 2 ? false : true;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.deckInitandShuffle();

        List<Hand> hands = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            List<Card> cards1 = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                cards1.add(deck.giveOneCard());
            }
            hands.add(new Hand(cards1));

        }

        hands.stream().forEach(hand -> {
            System.out.println("\n hands in game \n");
            System.out.println(hand);
        });

        System.out.println("Our winners: ");
        WhoWin.checkWhoWin(hands).stream().forEach(System.out::println);
    }
}
