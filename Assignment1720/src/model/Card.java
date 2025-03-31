//Project Name: Super Madiao
//Team Members: Filza Ahmed;      Shimiao Wang: 216814576
//Date: 01/03/2025
//Class: EECS-1720

package model;

/**
 * Represents a playing card in the Super Madiao game. Each card has a suit, a
 * rank, and special properties.
 *
 * Member 2 Guidance: This is a backend class for modeling the card. As a
 * frontend developer, you may want to create a visual representation of a card.
 * Consider creating a separate class (e.g., CardView in a "view" package) that
 * uses this Card instance to render the card on a GUI (using Java Swing or
 * AWT).
 *
 * Some suggestions: 1. Create a class named CardView that extends a Swing
 * component (e.g., JPanel). 2. Use the card's properties (suit, rank, and
 * isRevealed) to decide which image or text to display. 3. Override the
 * paintComponent(Graphics g) method to draw the card. 4. Add mouse or key
 * listeners in CardView if you want interactive events (e.g., clicking to
 * reveal the card).
 *
 * For example, a simple skeleton for CardView could be:
 *
 * ----------------------------------------------------------- package view;
 *
 * import javax.swing.*; import java.awt.*; import model.Card;
 *
 * public class CardView extends JPanel { private Card card;
 *
 * public CardView(Card card) { this.card = card; setPreferredSize(new
 * Dimension(100, 150)); // Set size as needed // You can add mouse listeners
 * here to handle interactions }
 *
 * @Override protected void paintComponent(Graphics g) {
 *           super.paintComponent(g); if(card.isRevealed()) { // Draw card face
 *           (could be an image or text) g.drawString(card.getRank().toString()
 *           + " of " + card.getSuit().toString(), 10, 20); } else { // Draw
 *           card back (e.g., a default image or text) g.drawString("Card Back",
 *           10, 20); } } }
 *           -----------------------------------------------------------
 *
 *           Feel free to modify this framework based on the final GUI design.
 */
public class Card {

	/**
	 * Enum representing the four suits of the game.
	 */
	public enum Suit {
		COINS, CHALICES, WANDS, SWORDS
	}

	/**
	 * Enum representing the ranks of the cards. The numerical cards are 1-6.
	 * Special cards include Queen, King, Myriad, and Divine.
	 */
	public enum Rank {
		ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

		private final int value;

		Rank(int value) {
			this.value = value;
		}

		/**
		 * Returns the numeric value associated with the rank.
		 *
		 * @return the value of the rank.
		 */
		public int getValue() {
			return value;
		}
	}

	private Suit suit; // The suit of the card (Coins, Chalices, Wands, Swords)
	private Rank rank; // The rank of the card (1-6, Queen, King, Myriad, Divine)
	private boolean isSpecial; // True if the card is a special card (Queen, King, Myriad, Divine)
	private boolean isRevealed; // True if the card is face-up, false if face-down

	/**
	 * Constructor to create a new card.
	 *
	 * @param suit The suit of the card.
	 * @param rank The rank of the card.
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.isRevealed = false; // Default state is face-down
	}

	/**
	 * Returns the suit of the card.
	 *
	 * @return Suit of the card.
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Returns the rank of the card.
	 *
	 * @return Rank of the card.
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Reveals the card, making its identity known.
	 */
	public void revealCard() {
		this.isRevealed = true;
	}

	/**
	 * Hides the card, making it face-down.
	 */
	public void hideCard() {
		this.isRevealed = false;
	}

	/**
	 * Checks if the card is currently revealed.
	 *
	 * @return True if the card is face-up, false if face-down.
	 */
	public boolean isRevealed() {
		return isRevealed;
	}

	/**
	 * Returns a string representation of the card.
	 *
	 * @return The card's rank and suit if revealed, or "Facedown Card" if hidden.
	 */
	@Override
	public String toString() {
		if (isRevealed) {
			return rank + " of " + suit;
		} else {
			return "Facedown Card";
		}
	}

}
