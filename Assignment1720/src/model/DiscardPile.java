package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The DiscardPile class manages cards that have been discarded during the game.
 *
 * UML Reference: - cards: List<Card> - addToPile(cards: List<Card>): void -
 * removeLastCards(): List<Card>
 *
 * Member 2 Guidance: ------------------ 1. For a GUI, you might display the
 * DiscardPile as a stack of face-up cards or a simple label indicating how many
 * cards have been discarded. 2. If you want to show the top card of the
 * DiscardPile in your GUI, consider retrieving it from this class and rendering
 * it with your CardView. 3. You could add more methods to see the top card
 * (e.g., getTopCard()) if needed.
 */
public class DiscardPile {

	// Stores all discarded cards.
	private List<Card> cards;

	/**
	 * Default constructor initializes an empty discard pile.
	 */
	public DiscardPile() {
		this.cards = new ArrayList<>();
	}

	/**
	 * Adds a list of cards to the discard pile.
	 *
	 * @param newCards the cards to be added to the pile
	 */
	public void addToPile(List<Card> newCards) {
		cards.addAll(newCards);
	}

	public Card getTopCard() {
		if (!cards.isEmpty()) {
			return cards.get(cards.size() - 1);
		}
		return null;
	}

	/**
	 * Returns a copy of the list of discarded cards.
	 *
	 * @return A list of cards in the discard pile.
	 */
	public List<Card> getCards() {
		return new ArrayList<>(cards);
	}

	/**
	 * Removes and returns the "last cards" from the pile. Depending on your game
	 * logic, you can define "last cards" differently. For now, we assume it clears
	 * the entire pile and returns them.
	 *
	 * @return the cards that were in the discard pile
	 */
	public List<Card> removeLastCards() {
		List<Card> removed = new ArrayList<>(cards);
		cards.clear();
		return removed;
	}

	/**
	 * (Optional) Returns the total number of cards in the discard pile. Not in the
	 * UML, but often useful.
	 */
	public int size() {
		return cards.size();
	}
}
