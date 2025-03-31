//Project Name: Super Madiao
//Team Members: Filza Ahmed;      Shimiao Wang: 216814576
//Date: 01/03/2025
//Class: EECS-1720
package model;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private Player player;
    private List<Card> cards;
    private Card.Rank declaredRank;

    public Play(Player player, List<Card> cards, Card.Rank declaredRank) {
        this.player = player;
        this.cards = new ArrayList<>();
        for (Card card : cards) {
            card.revealCard(); // Reveal the card
            this.cards.add(card);
        }
        this.declaredRank = declaredRank;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public Card.Rank getDeclaredRank() {
        return declaredRank;
    }

    public boolean matchesDeclaration() {
        for (Card card : cards) {
            if (card.getRank() != declaredRank) {
                return false;
            }
        }
        return true;
    }
}