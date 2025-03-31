//Project Name: Super Madiao
//Team Members: Filza Ahmed;      Shimiao Wang: 216814576
//Date: 01/03/2025
//Class: EECS-1720

package model;

import java.util.List;

public class Manager {
	private List<Player> players;
	private Deck deck;
	private Pile pile;
	private DiscardPile discardPile;
	private int currentPlayerIndex = 0; // trace

	public Manager(List<Player> players) {
		this.players = players;
		this.deck = new Deck();
		this.pile = new Pile();
		this.discardPile = new DiscardPile();
		dealInitialCards();
	}

	// Start
	private void dealInitialCards() {
		deck.shuffle();
		while (deck.size() > 0) {
			for (Player player : players) {
				if (deck.size() == 0)
					break;
				player.receiveCard(deck.draw());
			}
		}
	}

	// logic 1(play cards)
	public void playCards(Player player, List<Card> cards, Card.Rank declaredRank) {
		if (player != getCurrentPlayer()) {
			throw new IllegalStateException("Not your turn！");
		}
		if (!player.getHand().containsAll(cards)) {
			throw new IllegalArgumentException("You don't have these cards！");
		}
		if (cards.size() < 1 || cards.size() > 4) {
			throw new IllegalArgumentException("You have to play 1-4 cards！");
		}

		player.playCard(cards);
		Play play = new Play(player, cards, declaredRank);
		pile.addPlay(play);
		nextPlayer();
	}

	// Challenge moved to here
	public boolean challengePlayer(Player challenger) {
		Play lastPlay = pile.getLastPlay();
		if (lastPlay == null)
			return false; // no card to challenge

		if (!lastPlay.matchesDeclaration()) { // challenge succeed
			Player target = lastPlay.getPlayer();
			target.receivePenalty(pile.getAllCards());
			pile.clearPile();
			return true;
		} else { // failed
			challenger.receivePenalty(pile.getAllCards());
			pile.clearPile();
			return false;
		}
	}

	// Winner Checker
	public Player checkForWinner() {
		for (Player player : players) {
			if (player.getHand().isEmpty())
				return player;
		}
		return null;
	}

	// switch to nextPlayer
	public void nextPlayer() {
		currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
	}

	// getCurrentPlayer
	public Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}

	public Pile getPile() {
		return pile;
	}

	public DiscardPile getDiscardPile() {
		return discardPile;
	}

}