package com.github.java3wro.project.badugi.service;

import com.github.java3wro.project.badugi.enums.Rank;
import com.github.java3wro.project.badugi.model.Card;

import java.util.List;
import java.util.stream.Collectors;


public class RemovesExpendableCardsFromHand {

        public static List<Card> checkHandsPlayer(List<Card> listForCheck) {


            for (int i = 0; i < listForCheck.size() - 1; i++) {
                if (listForCheck.get(i).getCardColors().equals(listForCheck.get(i + 1).getCardColors())) {
                    if (isUniqCard(listForCheck, i)) {
                        listForCheck.remove(i);
                    } else if (isUniqCard(listForCheck, i + 1)) {
                        listForCheck.remove(i + 1);
                    } else {
                        int checkMin = listForCheck.get(i).getCardFigures().compareTo(listForCheck.get(i + 1).getCardFigures());
                        if (checkMin < 0) {
                            listForCheck.remove(i + 1);
                        } else {
                            listForCheck.remove(i);
                        }
                    }
                    i--;
                }
            }
            return listForCheck;
        }

        public static boolean isUniqCard(List<Card> listToCheck, int index) {

            List<Rank> ranks = listToCheck
                    .stream()
                    .map(card -> card.getCardFigures())
                    .filter(figure -> listToCheck.get(index).equals(figure))
                    .collect(Collectors.toList());
            return ranks.size() >= 2 ? true : false;
        }
//
//        public static void main(String[] args) {
//            List<Card> list = new ArrayList<>();
//
//            Card card1 = new Card();
//            Card card2 = new Card();
//            Card card3 = new Card();
//            Card card4 = new Card();
//
//            card1.setCardColors(CLUBS);
//            card1.setCardFigures(KING);
//
//            card2.setCardColors(CLUBS);
//            card2.setCardFigures(TWO);
//
//            card3.setCardColors(CLUBS);
//            card3.setCardFigures(THREE);
//
//            card4.setCardColors(DIAMONDS);
//            card4.setCardFigures(TWO);
//
//            list.add(card1);
//            list.add(card2);
//            list.add(card3);
//            list.add(card4);
//
//            for (Card card : checkHandsPlayer(list)){
//                System.out.println(card);
//            }
//        }
    }

