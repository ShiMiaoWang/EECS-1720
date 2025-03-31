//Project Name: Super Madiao
//Team Members: Filza Ahmed;      Shimiao Wang: 216814576
//Date: 01/03/2025
//Class: EECS-1720
package model;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    private List<Play> plays;

    public Pile() {
        this.plays = new ArrayList<>();
    }

    public void addPlay(Play play) {
        plays.add(play);
    }

    public Play getLastPlay() {
        if (!plays.isEmpty()) {
            return plays.get(plays.size() - 1);
        }
        return null;
    }

    public List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>();
        for (Play play : plays) {
            allCards.addAll(play.getCards());
        }
        return allCards;
    }

    public void clearPile() {
        plays.clear();
    }

    public Card getTopCard() {
        Play lastPlay = getLastPlay();
        if (lastPlay != null && !lastPlay.getCards().isEmpty()) {
            return lastPlay.getCards().get(lastPlay.getCards().size() - 1);
        }
        return null;
    }
}