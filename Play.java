package model;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private Player player;
    private List<Card> cards;
    private Card.Rank declaredRank;

    public Play(Player player, List<Card> cards, Card.Rank declaredRank) {
        this.player = player;
        this.cards = new ArrayList<>(cards);
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