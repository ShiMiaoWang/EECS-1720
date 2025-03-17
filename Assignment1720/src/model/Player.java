package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Player class represents a participant in the game, managing their hand of
 * cards.
 *
 * UML Reference: ----------------- - name: String - hand: List<Card> -
 * playCard(cards: List<Card>): void - challengePlayer(target: Player): Boolean
 * - receivePenalty(cards: List<Card>): void
 *
 * GUI Integration Notes: ----------------- 1. The GUI should display each
 * player's hand using getHand(). 2. A "Play Card" button should call playCard()
 * and update the UI. 3. The challengePlayer() method should trigger an in-game
 * challenge, updating both players. 4. When a penalty is applied, update the
 * player's hand visually.
 */
public class Player {

	private String name; // Player's name
	private List<Card> hand; // The player's hand of cards

	/**
	 * Constructs a new player with a given name.
	 * 
	 * @param name The player's name.
	 */
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}

	/**
	 * Gets the player's name.
	 * 
	 * @return The player's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the player's current hand.
	 * 
	 * @return The list of cards in the player's hand.
	 */
	public List<Card> getHand() {
		return hand;
	}

	/**
	 * Adds a card to the player's hand.
	 * 
	 * @param card The card to add.
	 */
	public void receiveCard(Card card) {
		hand.add(card);
	}

	/**
	 * Plays a set of cards from the player's hand. Removes them from the hand and
	 * returns them for game processing.
	 *
	 * @param cards The list of cards the player wants to play.
	 */
	public void playCard(List<Card> cards) {
		hand.removeAll(cards);
	}

//	/**
//	 * Challenges another player's play.
//	 * 
//	 * @param target The player being challenged.
//	 * @return True if the challenge was successful (target was lying), false
//	 *         otherwise.
//	 */
//	public boolean challengePlayer(Player target) {
//		// The GameManager should handle challenge logic,
//		// but we assume it interacts with this method.
//		return false; // Placeholder (actual check should be in GameManager)
//	}

	/**
	 * Applies a penalty to the player by adding a list of cards to their hand. This
	 * happens when a challenge fails.
	 * 
	 * @param cards The penalty cards to be added.
	 */
	public void receivePenalty(List<Card> cards) {
		hand.addAll(cards);
	}
}
