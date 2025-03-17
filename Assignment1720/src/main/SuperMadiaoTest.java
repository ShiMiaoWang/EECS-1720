package main;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class SuperMadiaoTest {
	public static void main(String[] args) {
		// Create players
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		List<Player> players = new ArrayList<>();
		players.add(alice);
		players.add(bob);

		// Initialize game manager
		Manager gameManager = new Manager(players);
		System.out.println("Game initialized. Initial hands:");
		System.out.println("Alice's hand: " + alice.getHand());
		System.out.println("Bob's hand: " + bob.getHand());

		// Simulate game rounds until a winner emerges
		int round = 1;
		while (gameManager.checkForWinner() == null) {
			System.out.println("\nRound " + round + ":");
			Player currentPlayer = gameManager.getCurrentPlayer();
			System.out.println("Current player: " + currentPlayer.getName());

			// Play cards (up to 2 cards for simplicity)
			List<Card> cardsToPlay = new ArrayList<>();
			List<Card> hand = currentPlayer.getHand();
			int cardsToSelect = Math.min(2, hand.size());
			for (int i = 0; i < cardsToSelect; i++) {
				cardsToPlay.add(hand.get(i));
			}
			Card.Rank declaredRank = Card.Rank.KING; // Always declare KING for this test
			System.out.println(currentPlayer.getName() + " plays " + cardsToPlay + " as " + declaredRank);
			gameManager.playCards(currentPlayer, cardsToPlay, declaredRank);

			// Next player challenges
			Player nextPlayer = gameManager.getCurrentPlayer();
			System.out.println(nextPlayer.getName() + " challenges the play.");
			boolean challengeResult = gameManager.challengePlayer(nextPlayer);
			if (challengeResult) {
				System.out.println("Challenge successful! " + currentPlayer.getName() + " was lying.");
			} else {
				System.out.println("Challenge failed. " + currentPlayer.getName() + " was truthful.");
			}
			System.out.println("Alice's hand: " + alice.getHand());
			System.out.println("Bob's hand: " + bob.getHand());

			round++;
			if (round > 10)
				break; // Prevent infinite loop in this test
		}

		// Check for winner
		Player winner = gameManager.checkForWinner();
		if (winner != null) {
			System.out.println("\nGame over! Winner is: " + winner.getName());
		} else {
			System.out.println("\nGame stopped after 10 rounds. No winner yet.");
		}
	}
}