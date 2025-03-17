package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class manages a collection of Card objects for the Super Madiao
 * game.
 *
 * UML Reference: - cards: List<Card> - shuffle(): void - draw(): Card
 *
 * For Your(member 2) Guidance: ------------------ 1. This class is purely for
 * backend logic. You do NOT need to modify it to show graphics. 2. If you want
 * to display the deck in a GUI, consider creating a DeckView or a panel that
 * shows how many cards are left in the deck. You might show a "Deck" image or
 * just a label like "Deck: 40 cards left." 3. In your GUI, you may call
 * deck.draw() whenever the user needs to draw a card. Then you'll receive a
 * Card object, which you can pass to your CardView (front-end).
 */
public class Deck {

	// A list to hold all 40 cards for Super Madiao.
	private List<Card> cards;

	/**
	 * Default constructor that initializes the deck with 40 cards: - 4 suits:
	 * COINS, CHALICES, WANDS, SWORDS - 10 ranks each: 1,2,3,4,5,6, QUEEN, KING,
	 * MYRIAD, DIVINE Automatically shuffles the deck upon creation.
	 */
	public Deck() {
		cards = new ArrayList<>();
		// Populate the deck with 40 unique cards
		for (Card.Suit suit : Card.Suit.values()) {
			// We have 10 ranks in total
			cards.add(new Card(suit, Card.Rank.ONE));
			cards.add(new Card(suit, Card.Rank.TWO));
			cards.add(new Card(suit, Card.Rank.THREE));
			cards.add(new Card(suit, Card.Rank.FOUR));
			cards.add(new Card(suit, Card.Rank.FIVE));
			cards.add(new Card(suit, Card.Rank.SIX));
			cards.add(new Card(suit, Card.Rank.QUEEN));
			cards.add(new Card(suit, Card.Rank.KING));
			cards.add(new Card(suit, Card.Rank.MYRIAD));
			cards.add(new Card(suit, Card.Rank.DIVINE));
		}

		// Shuffle the deck as soon as it's created
		shuffle();
	}

	/**
	 * Shuffles the deck using a built-in randomization method.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Draws (removes and returns) the top card from the deck.
	 *
	 * @return The top Card if the deck is not empty, otherwise null.
	 */
	public Card draw() {
		if (!cards.isEmpty()) {
			return cards.remove(0);
		}
		return null; // or throw an exception if you prefer
	}

	/**
	 * Gets the current number of cards in the deck.
	 *
	 * @return The size of the deck.
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * (Optional) A utility method for debugging that prints out all cards in the
	 * deck. Not required by the UML, but helpful.
	 */
	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
